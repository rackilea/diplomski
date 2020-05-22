BufferedImage image = ImageIO.read(url);

yourJMenu.setHorizontalTextPosition(SwingConstants.CENTER);
yourJMenu.setVerticalTextPosition(SwingConstants.BOTTOM);

yourJMenu.setIcon(new ImageIcon(image));