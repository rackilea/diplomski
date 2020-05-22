BufferedImage image = ImageIO.read(new File("img.jpg"));
    BufferedImage img = new BufferedImage(200,150,BufferedImage.TYPE_INT_RGB);
    img.getGraphics().drawImage(image,0,0,200,150,null);

    JLabel label = new JLabel(new ImageIcon(img));
    add(label);