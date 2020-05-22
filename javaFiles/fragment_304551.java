class MyPanel extends JPanel {
    // Background image. Initialize appropriately.
    Image backgroundImage;

    public MyPanel() {
         // Add a MouseListener which processes mouse clicks.
         this.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                 // Process mouse-click.
             }
         })
    }

    // paintComponents method here.
}