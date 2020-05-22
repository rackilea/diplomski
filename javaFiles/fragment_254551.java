File im1 = chooser.getSelectedFile();    
BufferedImage buff = ImageIO.read(im1);

if (buff != null) {
    System.out.println(buff.getWidth() + " " + buff.getHeight());
    System.out.println(buff.getRGB(0, 0));
}