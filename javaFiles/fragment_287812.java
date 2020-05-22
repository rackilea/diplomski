String str =
    features.stream()
            .filter(s -> "Lambdas".equals(s))
            .map(this::toLowerCase)
            .findFirst()
            .orElse(null); // default value or orElseThrow