try (
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(connection.getInputStream(), charset)
    )
) {
    String content = reader.lines().collect(Collectors.joining("\n"));
    ...
}