try (DirectoryStream<Path> dir = Files.newDirectoryStream(
        Paths.get("C:\\Users\\Documents\\TestBlankFiles"))) {

    for (Path file : dir) {
        String name = file.getFileName().toString();
        if (!Files.isDirectory(file) && name.length() >= 14) {
            char yearDigit = name.charAt(13);

            Path destDir = Paths.get(
                "C:\\Users\\Documents\\TestBlankFiles\\201" + yearDigit);
            Files.createDirectories(destDir);
            Files.move(file, destDir.resolve(name));
        }
    }
}