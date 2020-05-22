public void perspective() throws Exception{
    BufferedImage srcImage = ImageIO.read(new File("flower.jpg"));
    BufferedImage destImage = null;

    int w = srcImage.getWidth();
    int h = srcImage.getHeight();

    PerspectiveFilter perspectiveFilter = new PerspectiveFilter();
    perspectiveFilter.setCorners(w/4, 0, w-w/4, 0, w, h, 0, h);     
    destImage = perspectiveFilter.filter(srcImage, destImage);

    ImageIO.write(destImage,"jpg",new File("modified_flower.jpg"));
}