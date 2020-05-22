public void smoothing(){
     filter = new float[] { 1.0f/121.0f,  2.0f/121.0f,   3.0f/121.0f,   2.0f/121.0f,   1.0f/121.0f,
                            2.0f/121.0f,  7.0f/121.0f,  11.0f/121.0f,   7.0f/121.0f,   2.0f/121.0f,
                            3.0f/121.0f, 11.0f/121.0f,  17.0f/121.0f,  11.0f/121.0f,   3.0f/121.0f,
                            2.0f/121.0f,  7.0f/121.0f,  11.0f/121.0f,   7.0f/121.0f,   2.0f/121.0f,
                            1.0f/121.0f,  2.0f/121.0f,   3.0f/121.0f,   2.0f/121.0f,   1.0f/121.0f};
    kernelWidth = 5;
    kernelHeight = 5;
    kernel = new Kernel( kernelWidth, kernelHeight, filter);
    op = new ConvolveOp(kernel); 

    img = Toolkit.getDefaultToolkit().getImage(Interface.picPath);
    imageToBufferedImage(img);
    bufImg = op.filter(bufImg, null);

    icon = new ImageIcon(img.getScaledInstance(175, 175, Image.SCALE_DEFAULT));
    icon2 = new ImageIcon(img.getScaledInstance(300, 300, Image.SCALE_DEFAULT));
    Interface.label3.setIcon(icon);
    Interface.label8.setIcon(icon2);

}

public  void imageToBufferedImage(Image im) {
    ImageSize size = new ImageSize(im);
    bufImg = new BufferedImage (size.getwidth(), size.getheight(),BufferedImage.TYPE_INT_RGB);
    Graphics graph = bufImg.getGraphics();
    graph.drawImage(im, 0, 0, null);
    graph.dispose();