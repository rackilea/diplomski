public void cleanFormat() {
    for (int i = 0; i < directories.size(); i++) {
        File currentDirectory = directories.get(i);
        for (File currentFile : currentDirectory.listFiles()) {
            String formattedName = "";
            formattedName = currentFile.getName().replace(".", " ");
            formattedName = formattedName.replace("  ", " ");
            Path source = currentFile.toPath();
            try {
                Files.move(source, source.resolveSibling(formattedName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}