public class SliderPane extends JPanel {

    private double sliderValue;

    public double getSliderValue() {
        return sliderValue;
    }

    public void setSliderValue(double sliderValue) {
        this.sliderValue = Math.max(Math.min(1.0, sliderValue), 0);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.cyan);          
        g.fillRect(0, 0, width, height);         // The blue sky
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, width, (int)(sliderValue * height)); // The blind, partially closed
        g.setColor(Color.black);
        g.drawRect(0, 0, width, height);         // The window frame
    }

}