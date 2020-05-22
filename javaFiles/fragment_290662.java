...
Image filteredImage = Toolkit.getDefaultToolkit().createImage(ip);          
ImageIcon swingImage = new ImageIcon(filteredImage);
JFrame frame = new JFrame();
JLabel label = new JLabel(swingImage);
frame.add(label);
frame.setVisible(true);
frame.dispose();
BufferedImage bim = new BufferedImage( originalImage.getIconWidth(),originalImage.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

Graphics2D g2 = bim.createGraphics();
g2.drawImage(filteredImage, 0, 0, null);
g2.dispose();
File file = new File(directory + File.separator + baseFileName + ".png");
file.createNewFile();
boolean status = ImageIO.write(bim, "png", file);
System.out.print("write() status: " + status);
}