Entry<JdbConnection, Instant> entry =
    borrowed.entrySet().stream()
        .filter(entry -> Duration.between(entry.getValue(), Instant.now())
                            .toMillis() > leaseTimeInMillis)
        .findFirst()
        .orElseThrow(ConnectionPoolException::new));
entry.getKey().close();
borrowed.remove(entry.getKey());