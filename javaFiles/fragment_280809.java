StringBuilder sb = new StringBuilder();
try (OutputStream out = new Base64Encoder(sb)) {
    javax.imageio.ImageIO.write(image, "png", out);
} catch (IOException e) {
    throw new RuntimeException(e);
}
String imageData = sb.toString();