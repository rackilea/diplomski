package com.stackoverflow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static me.karun.Policy.policy;
import static me.karun.Role.role;
import static org.assertj.core.api.Assertions.assertThat;

public class PoliciesTest {

  @Test
  public void streamImplementation_whenComparedWithALoopImplementation_thenShouldReturnTheSameResult() {
    final String userId = "user-1";
    final Role role1 = role("role-1", "user-1", "user-2");
    final Role role2 = role("role-2", "user-1", "user-3");
    final Role role3 = role("role-3", "user-2", "user-3");
    final Role role4 = role("role-4", "user-3", "user-4");
    final List<Policy> allowedPoliciesThisCustomer = asList(
      policy(role1, role2),
      policy(role3, role4)
    );
    final Set<String> oldResult = loopImplementation(userId, allowedPoliciesThisCustomer);
    final Set<String> newResult = streamImplementation(userId, allowedPoliciesThisCustomer);

    assertThat(newResult).isEqualTo(oldResult);
  }

  private static Set<String> streamImplementation(final String userId, final List<Policy> allowedPoliciesThisCustomer) {
    return allowedPoliciesThisCustomer.stream()
      .map(Policy::getRoles)
      .map(Map::values)
      .flatMap(Collection::stream)
      .filter(r -> r.getUsers().contains(userId))
      .map(Role::getRoleName)
      .collect(toSet());
  }

  private static Set<String> loopImplementation(final String userId, final List<Policy> allowedPoliciesThisCustomer) {
    final Set<String> allowedRolesThisUser = new HashSet<>();

    for (final Policy policy : allowedPoliciesThisCustomer) {
      final Map<String, Role> roles = policy.getRoles();
      for (final Role role : roles.values()) {
        if (role.getUsers().contains(userId)) {
          allowedRolesThisUser.add(role.getRoleName());
        }
      }
    }

    return allowedRolesThisUser;
  }
}

@RequiredArgsConstructor
@Getter
class Policy {
  private final Map<String, Role> roles;

  static Policy policy(final Role... roles) {
    final Map<String, Role> rolesMap = stream(roles)
      .collect(toMap(Role::getRoleName, identity()));

    return new Policy(rolesMap);
  }
}

@RequiredArgsConstructor
@Getter
class Role {
  private final List<String> users;
  private final String roleName;

  static Role role(final String roleName, final String... users) {
    return new Role(asList(users), roleName);
  }
}