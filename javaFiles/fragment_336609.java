public class Rectangles extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 15;
        int y = 15;
        int w = 15;
        int h = 15;
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                g.setColor(Color.RED);
                g.fillRect(x, y, w, h);
            } else {
                g.setColor(Color.BLUE);
                g.drawRect(x, y, w, h);
            }
            x += 15;
            System.out.println(Integer.toString(x) + ' ' + Integer.toString(y) + '|' + Integer.toString(w) + ' ' + Integer.toString(h));
        }
    }
}