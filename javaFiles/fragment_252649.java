@Override
public Mono<User> findByEmail(String email) {

    Mono<User> fallback = Mono.error(new NotFoundException("No user account was found with email: " + email));
    return repository.findByEmail(email).switchIfEmpty(fallback);
}