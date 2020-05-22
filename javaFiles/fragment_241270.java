class MyCustomPanel extends JPanel {

    private int numberOfArrows = 0;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // never forget to call super.paintComponent(g)
        Graphics graphics = g.create();
        int y = 10;
        for(int i = 0; i < numberOfArrows; i++) {                
            graphics.drawLine(10, y, getWidth() - 10, y); // instead of lines just draw your arrows
            y += 10;
        }
        graphics.dispose();
    }

    /**
     * Public method to set the number of arrows that has to be drawn.
     * @param arrows 
     */
    public void setNumberOfArrows(int arrows) {
        numberOfArrows = arrows;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return isPreferredSizeSet() 
             ? super.getPreferredSize() : new Dimension(200,200);
    }
}