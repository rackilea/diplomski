private int X;
private int Y;

@Override
public void mouseClicked(MouseEvent m) {
    gebeurtenisverslag.setText( 
            m.getClickCount() + " keer geklikt op " + m.getX() + "," + m.getY());
    X = m.getX();
    Y = m.getY();
}

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //Probably want to add logic here to verify X & Y have been set
    punt.setDot(g, X, Y, 5);
    repaint();
}