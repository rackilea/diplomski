@Override
public boolean imageUpdate(Image img,
              int infoflags,
              int x,
              int y,
              int width,
              int height) {
    if ((infoflags & ImageObserver.ALLBITS) == ImageObserver.ALLBITS) {
        // The image is entirely read.
        repaint();
    }
}