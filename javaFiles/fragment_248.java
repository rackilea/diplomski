Files.walk(Paths.get(root)).forEach(filePath -> {
    try {
        if (Files.isRegularFile(filePath) && !Files.isHidden(filePath)) {
            System.out.println(filePath);
        }
    } catch (IOException e) {
        e.printStackTrace(); // Or something more intelligent
    }
});