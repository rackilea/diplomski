private JPanel panel;

...

private void moveLeft() {
    Rectangle rec = panel.getVisibleRect();
    rec.setLocation((int) (rec.getX() + 1000), (int) rec.getY());
    System.out.println(rec);
    panel.scrollRectToVisible(rec);
    System.out.println(panel.getVisibleRect());
}