public byte[] getByteArrayFromImageS3Bucket(String fileName) throws IOException {
    InputStream in = getImageFromS3Bucket(fileName).getObjectContent();

    BufferedImage imageFromAWS = ImageIO.read(in);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(imageFromAWS, "png", baos );
    byte[] imageBytes = baos.toByteArray();
    in.close();
    return imageBytes;

}