// (1)
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
        // (2)
        String json = reader.lines().collect(Collectors.joining("\n"));
        // do something with `json`...

    }