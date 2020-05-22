BufferedImage image = null;
try (InputStream is = blob.getBinaryStream()) {
    image = ImageIO.read(is);
} catch (IOException exp) {
    exp.printStackTrace();
}