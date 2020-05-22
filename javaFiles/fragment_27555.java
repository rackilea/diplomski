----JPanel----------------------------|
| ---Screen el----------------------  |
| |             txt                 | |
| |                                 | |
| ----------------------------------- |
| ---seats -------------------------- |
| |seat1  seat2 .. ...  ...  ...    | |
| |seat11 seat12 .. ...  ...  ..    | |
| |... ... ...                      | |
| ----------------------------------- |
---------------------------------------


public class Mango {

    public static void main(String[] atrg) throws IOException {
    JFrame meinJFrame = new JFrame();
    meinJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    meinJFrame.setSize(800, 600);
    meinJFrame.setVisible(true);
    meinJFrame.add(new RectDraw());
    JPanel over = new JPanel(new GridLayout(2, 1));
    over.add(new RectDraw());
    meinJFrame.setTitle("Cinemax-Beispiel");
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(6, 5));
    for (int i = 1; i <= 30; i++) {
        panel.add(new JToggleButton("Seat :" + i));
    }
    over.add(panel);
    meinJFrame.add(over);
    }
}

class RectDraw extends JPanel {
    private static final long serialVersionUID = -6507364980760764676L;

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.GRAY);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(Color.WHITE);
    g.drawString("Movie Sceen", 130, 20);
    }
}