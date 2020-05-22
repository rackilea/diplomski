Comparator<File> comparator = Comparator.comparing(file -> {
    try {
        return Files.readAttributes(Paths.get(file.toURI()), BasicFileAttributes.class).creationTime();
    } catch (IOException e) {
        return null;
    }
});

Arrays.sort(files, comparator);