class GUI extends JComponent {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        g.drawString("Hello People!", 2, 10);
    }  
}