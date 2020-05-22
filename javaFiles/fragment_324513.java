@Override
public void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    g.setColor(Color.RED);
    g.fillRect(x, y, 40, 60);

    g.setColor(Color.GRAY);
    g.fillRect(0, hitscany, 650, 0);

    if (y == hitscany) {
        int complete = 1;
        Mayflower bob = new Mayflower();
        bob.epic(complete);

    }

    time.start();

}