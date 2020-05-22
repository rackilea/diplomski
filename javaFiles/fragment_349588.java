public class GraphPanel extends Canvas {

    private static final int PREF_WIDTH = 1100;
    private static final int PREF_HEIGHT = 600;

    public GraphPanel() {
        setBackground(Color.WHITE);
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int width = (int) (getWidth() * 0.8);
        int height = (int) (getHeight() * 0.8);

        int x = (getWidth() - width) / 2;
        int y = (getHeight() - height) / 2;

        //Not working as intented
        g.drawRect(x, y, width, height);
    }
}