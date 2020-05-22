public class CityScape extends JPanel {

    Buildings a = new Buildings();
    UFO b = new UFO();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        a.paint(g);
        b.paint(g);
    }