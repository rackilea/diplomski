final Pattern pattern = Pattern.compile("\\d+\\..*");
try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir),
        entry -> pattern.matcher(entry.getFileName().toString()).matches())) {
    for (Path path : stream) {
        // do what you want
    }
}