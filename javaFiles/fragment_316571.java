@Override
protected void paintComponent(Graphics g) {
    if (showDot) {
        Graphics gCopy = g.create();

        gCopy.setColor(new Color(0.0f, 0.25f, 1.0f));
        gCopy.fillOval(x - k, y - k, 2*k, 2*k);

        gCopy.dispose();
    }
}