try {
    Path dir = Paths.get("./brieven").toRealPath();
    if (Files.exists(dir) && Files.isDirectory(dir) && Desktop.isDesktopSupported()) {
        Desktop.getDesktop().open(dir.toFile());
    }
} catch (IOException exc) {
    exc.printStackTrace();
}