public void paint(Graphics g) {
    if (connectionWorked == true) {
        g.setColor(Color.green);
        g.fillRect(0, 0, getWidth(), getHeight());
    } else {
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}