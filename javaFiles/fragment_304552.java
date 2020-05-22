class MyPanel extends JPanel {
    // Background image. Initialize appropriately.
    Image backgroundImage;
    Point pointClicked;

    public MyPanel() {
         // Add a MouseListener which processes mouse clicks.
         this.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                 // Retrieve the point at which the mouse was clicked.
                 pointClicked = e.getPoint();

                 // Repaint the panel.
                 this.repaint();
             }
         })
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background image each time the panel is repainted.
        g.drawImage(backgroundImage, 0, 0, null);

        // Draw a little square at where the mouse was clicked.
        g.fillRect(pointClicked.x, pointClicked.y, 1, 1);
    }
}