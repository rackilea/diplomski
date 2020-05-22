JLabel imageLabel = new JLabel(image){
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent (g);
            if (image != null) {
                g.drawImage (image.getImage(), 300, 0, image.getIconWidth(), image.getIconHeight(), null);
            }
        }
    };