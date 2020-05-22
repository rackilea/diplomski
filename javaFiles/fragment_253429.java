Optional<Session> optionalSession = Optional.empty();
        try {
            optionalSession = Optional.of(super.getConnection());
            session = optionalSession.get();
            [...]
        } finally {
            optionalSession.ifPresent(this::closeSession);
        }