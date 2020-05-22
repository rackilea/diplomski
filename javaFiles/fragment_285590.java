CodeSource src = ClientMain.class.getProtectionDomain().getCodeSource();

URL jar = src.getLocation();
ZipInputStream zip = new ZipInputStream(jar.openStream());
ZipEntry entry = null;

while ((entry = zip.getNextEntry()) != null) {
    String entryName = entry.getName();
    if (entryName.endsWith(".png")) {
        BufferedImage image = ImageIO.read(zip);
        // ...
    }
}