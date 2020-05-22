private void imageToArray(){
    int width = originalBI.getWidth();
    int height = originalBI.getHeight();

    newBI = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = newBI.createGraphics();
    g.drawImage(originalBI, 0, 0, width, height, null);
    g.dispose();

}