@Override
protected void paintComponent(Graphics g) { // should be protected
    super.paintComponent(g);

    // need to re-initialize variables within this
    startPointX = (dim.getWidth() / 10) * 1;
    startPointY = (dim.getHeight() / 10) * 1;