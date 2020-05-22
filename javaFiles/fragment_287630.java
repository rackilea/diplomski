JButton button = new JButton(...);
button.setBorderPainted( false );
ImageIcon icon = (ImageIcon)button.getIcon();
Image image = icon.getImage();
Image scaled = image.getScaledImage(...);
button.setRolloverIcon( new ImageIcon( scaled ) );