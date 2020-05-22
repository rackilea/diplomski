public static BufferedImage rotate(BufferedImage originalImg, int angle) {
    BufferedImage rotateImage = null;
    try {
        rotateImage = new BufferedImage(originalImg.getWidth(), originalImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
        AffineTransform a90 = AffineTransform.getRotateInstance(Math.toRadians(angle), originalImg.getWidth() / 2, originalImg.getHeight() / 2);
        AffineTransformOp op90 = new AffineTransformOp(a90, AffineTransformOp.TYPE_BILINEAR);
        op90.filter(originalImg, rotateImage);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return rotateImage;
}