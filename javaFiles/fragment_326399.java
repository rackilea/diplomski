Path chmPath = Files.createTempFile(null, ".chm");

try (InputStream chmResource =
    getClass().getResourceAsStream("/resources/help.chm")) {

    Files.copy(chmResource, chmPath,
        StandardCopyOption.REPLACE_EXISTING);
}

Desktop.getDesktop().open(chmPath.toFile());