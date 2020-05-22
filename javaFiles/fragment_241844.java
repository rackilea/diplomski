public void purgeProcessedFile(File xmlFile, String fileDestination) {
    Path destFile = Paths.get(fileDestination, xmlFile.getName());
    Path directory = destFile.getParent();
    if (!Files.exist(directory)) {
        Files.createDirectories(directory);
    }
    if (!Files.exists(destFile)) {
        try {
            Files.move(xmlFile.toPath(), destFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            logger.error(e);
        }
    } else {
        logger.info("File with same name already exists at destination folder: "
                + fileDestination);
    }
}