private final Object offsetLock = new Object();

public Sprite(Image sprite) {
    this.sprite = sprite;

    synchronized(offsetLock) {
        int width = sprite.getWidth(this);
        xOffset = width/2;
        xOffsetSet = width != -1;
        int height = sprite.getHeight(this);
        yOffset = height/2;
        yOffsetSet = height != -1;
    }
}

@Override
public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
    assert img == sprite;
    if ((infoflags & WIDTH) != 0) {
        synchronized(offsetLock) {
            xOffset = width / 2;
            xOffsetSet = true;
        }
    } 
    if ((infoflags & HEIGHT) != 0) {
        synchronized(offsetLock) {
            yOffset = height / 2;
            yOffsetSet = true;
        }
    }
    return xOffsetSet && yOffsetSet;
}