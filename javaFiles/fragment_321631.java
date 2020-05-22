for(int j = 1; j <= number; j++){
    Color backColor = Color.white;
    final Image  image = new ImageIcon((images.get(j)) + ".jpg").getImage();
 // ^--- This is important
    panel.add(new JPanel() {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    });
}