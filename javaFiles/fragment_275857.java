public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    BufferedImage bi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
    Graphics2D gbi = bi.createGraphics();
    gbi.setColor(Color.black);
    gbi.setBackground(Color.white);

    // here
    gbi.clearRect(0, 0, bi.getWidth(), bi.getHeight());

    gbi.drawLine(100, 100, 100, 200);
    g2.drawImage(bi, null, 0, 0);
    int rgb = bi.getRGB(50, 50);    // off the black line
    int red = (rgb >> 16) & 0xFF;
    int green = (rgb >> 8) & 0xFF;
    int blue = (rgb & 0xFF);
    System.out.println(red + " " + green + " " + blue);
}