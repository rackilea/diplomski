public Mono<User> insertUser(User user) {
        return userRepository.findByUsername(user.username())
            .flatMap(__ -> Mono.error(new DuplicateResourceException("User already exists with username [" + user.username() + "]")))
            .switchIfEmpty(Mono.defer(() -> userRepository.insertUser(user)))
            .cast(User.class);
    }