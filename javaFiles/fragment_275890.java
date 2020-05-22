private static Set<String> streamImplementation(final String userId, 
  final List<Policy> allowedPoliciesThisCustomer) {

  return allowedPoliciesThisCustomer.stream()
    .map(Policy::getRoles)
    .map(Map::values)
    .flatMap(Collection::stream)
    .filter(r -> r.getUsers().contains(userId))
    .map(Role::getRoleName)
    .collect(Collectors.toSet());
}