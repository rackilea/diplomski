Path logoFile = Files.createTempFile("logo", ".png");
try (InputStream stream =
    getClass().getLoader().getResourceAsStream("logo_48.png")) {

    Files.copy(stream, logoFile, StandardCopyOption.REPLACE_EXISTING);
}
imagePart.attachFile(logoFile.toFile());