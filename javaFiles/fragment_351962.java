@Override
protected Point getInitialSize() {
    final Point size = super.getInitialSize();

    size.x = convertWidthInCharsToPixels(75);

    size.y += convertHeightInCharsToPixels(20);

    return size;
}