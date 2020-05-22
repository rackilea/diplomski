@GetMapping("/users")
public Mono<User> getPopulation() {
    return userRepository.findOldest()
            .flatMap(user -> {              // process the response from DB
                user.setTheOldest(true);
                return userRepository.save(user);
            })
            .map(user -> {...}); // another processing
}