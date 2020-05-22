class MyPanel extends JPanel {

    boolean drawGreenLine;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawLine(0, 0, 10, 10);
        if (drawGreenLine) {
            g.setColor(Color.GREEN);
            g.drawLine(10, 10, 20, 20);

        }  
    }
};