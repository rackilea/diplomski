private void initComponents() {

    Image123 = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Let the panel do whatever it was doing before.

            BufferedImage image = null;             
            try {                
                image = ImageIO.read(new File("Vampire-full.jpg"));
            } catch (IOException ex) {
                   // handle exception...
            }

            g.drawImage(image, 0, 0, null);      
        }
    };
    // ... your other codes ...
}