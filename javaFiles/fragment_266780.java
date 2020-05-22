private final Mono<Token> authenticateMono = getToken()
            .cache(
                    token -> Duration.between(Instant.now(), token.getExpires().toInstant()),
                    throwable -> Duration.ZERO,
                    () -> Duration.ZERO)

public Mono<Token> authenticate() {
    return authenticateMono;
}