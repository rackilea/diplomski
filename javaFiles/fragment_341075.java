public Sprite(Image sprite) {
    this.sprite = sprite;
}

protected updateOffsets() {
    updateWidth(sprite.getWidth(this));
    updateHeight(sprite.getHeight(this));
}

protected updateWidth(final int newWidth) {
    if (newWidth != -1) {
        xOffset = newWidth/2;
        xOffsetSet = true;
    }
}

protected updateHeight(final int newHeight) {
    if (newHeight!= -1) {
        yOffset = newHeight/2;
        yOffsetSet = true;
    }
}

@Override
public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
    assert img == sprite;
    if ((infoflags & WIDTH) != 0) {
        updateWidth(width);
    } 
    if ((infoflags & HEIGHT) != 0) {
        updateHeight(height);
    }
    return xOffsetSet && yOffsetSet;
}