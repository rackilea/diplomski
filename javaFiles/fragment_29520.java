public class DrawSquare extends JPanel {
    public Square square;
    public DrawSquare() {
        square = new Square();
    }

    @Override
    public void paintComponents(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponents(g);

    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);

        g.setColor(square.getC());
        g.fillRect(square.getX(), square.getY(), square.getR(), square.getR());
    }
}