private void saveImage(String img) throws Exception {
    FileOutputStream fileOut = new FileOutputStream(img);
    Robot r = new Robot();
    BufferedImage bi = r.createScreenCapture(new java.awt.Rectangle(
            (int) frame.getLocationOnScreen().getX(), (int) frame
                    .getLocationOnScreen().getY(), frame.getBounds().width,
            frame.getBounds().height));
    ImageIO.write(bi, "jpeg", fileOut);
    fileOut.flush();
    fileOut.close();
}