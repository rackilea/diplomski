final long SIZE_1GB = 1073741824L;
try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        new LimitedOutputStream(Files.newOutputStream(path), SIZE_1GB),
        StandardCharsets.UTF_8))) {
    //
}