public static void map(String building_code, String ts_code) throws IOException {
    BufferedImage image = ImageIO.read(new File("public/images/maps/" + building_code + "_" + ts_code.charAt(0) + ".png"));
    ... // add annotations
    ImageInputStream is = ImageIO.createImageInputStream(image);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, "png", baos);
    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    Response.current().contentType = "image/png";

    renderBinary(bais);
}