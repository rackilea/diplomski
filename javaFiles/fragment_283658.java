Set<String> allNeededRoles = allAuthAnnotations.stream()
                                             .flatMap(auth -> Arrays.stream(auth.roles))
                                             .collect(Collectors.toSet());

if (!currentUser.getRoles().containsAll(allNeededRoles)) {
    throw new AccessDeniedException(); //or whatever is appropriate
}