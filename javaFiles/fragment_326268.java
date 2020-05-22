public class MyComponentNew extends JPanel {
    private Color color = Color.BLUE;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
    }

    public void changeColor() {
        if (color == Color.BLUE) {
            color = Color.RED:
        } else {
            color = color.BLUE;
        }
        repaint();
    }
}