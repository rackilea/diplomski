Flux<User> getUsers(User user) {
  return getManager(user).expand(manager -> getManager(manager));
}

Mono<User> getManager(User user) {
  if (user.containsManager()) {
    return externalUserServiceClient.getManager(user)
      .filter(manager -> manager.getDepartment().startsWith("Development"));
  } else {
    return Mono.empty();
  }
}