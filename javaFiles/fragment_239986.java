public class MyPanel extends JPanel{

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.drawRoundRect(10, 10, this.getWidth()-20, this.getHeight()-20, 15, 15);
        g.setColor(Color.black);
        g.drawString("Hello", 75, 75);
    }

}