public static class redBoxPanel extends JPanel {
    @Override public void paintComponent(Graphics g) {
        // You need to call the superclass' paintComponent() so that the 
        // setBackground() you called in main() is painted.
        super.paintComponent(g);

        // You need to set the colour BEFORE drawing your rect
        g.setColor(Color.RED);

        // Now that we have a colour, perform the drawing
        g.fillRect(0, 0, 100, 100);

        // More, for fun
        g.setColor(Color.GREEN);
        g.drawLine(0, 0, 100, 100);
    }
}