String str =
    features.stream()
            .filter(s -> "Lambdas".equals(s))
            .findFirst()
            .map(this::toLowerCase)
            .orElse(null); // default value or orElseThrow