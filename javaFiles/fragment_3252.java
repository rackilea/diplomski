try (InputStream resource = this.getClass().getClassLoader().getResource("blacklisted.words")) {
    List<String> blacklistedWordsDatabase = new BufferedReader(
        new InputStreamReader(
            resource,
            StandardCharsets.UTF_8
        )
    ).lines()
    .collect(Collectors.toList());
}