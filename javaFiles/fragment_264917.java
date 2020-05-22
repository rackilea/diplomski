@Override
public void mousePressed(MouseEvent e) {
    p.add(new Point(e.getX(), e.getY()));
    revalidate();
    repaint();
}