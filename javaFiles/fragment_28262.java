int leftBound = 0;
    int rightBound = 0;
    double confVal = 0;
    double heightDouble = 0;
    int height = 0;

    g2.setColor(Color.LIGHT_GRAY);

    for (int i = 0; i < gfx.getCallboxCount(); i++) {
        leftBound = (int) gfx.getCallboxBounds(i).getX();
        rightBound = (int) ((int) leftBound + gfx.getCallboxBounds(i).getWidth());
        confVal = confidence[i] * 2.67;
        heightDouble = 200 - confVal;
        height = (int) heightDouble;
        g2.drawLine(leftBound, height, rightBound, height);
    }