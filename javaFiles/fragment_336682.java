try (Stream<Path> paths = Files.walk(Paths.get(path)).parallel()
    .filter(filePath->filePath.getFileName().toString().contains("ABC"))) {
        paths.forEach(filePath -> {
            //other staff...
        });
    } catch (IOException e) {

}