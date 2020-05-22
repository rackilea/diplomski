Label label = new Label(parent, SWT.BORDER);
    label.setSize(50, 30);
    label.setText("String");

    // Get the label size and the font data
    Point size = label.getSize();
    FontData[] fontData = label.getFont().getFontData();
    GC gc = new GC(label);

    int stringWidth = gc.stringExtent(label.getText()).x;

    // Note: In original answer was ...size.x + (double)..., must be / not +
    double widthRatio = (double) size.x / (double) stringWidth;
    int newFontSize = (int) (fontData[0].getHeight() * widthRatio);

    int componentHeight = size.y;
    int fontsizeToUse = Math.min(newFontSize, componentHeight);

    // set the font
    fontData[0].setHeight(fontsizeToUse);
    label.setFont(new Font(Display.getCurrent(), fontData[0]));

    gc.dispose();