private static final class WokerSync
{
  private Object        refImageMutex       = new Object();
  private BufferedImage refImageOpaque      = null;
  private BufferedImage refImageTranspMask  = null;
  private BufferedImage refImageTranslucent = null;

  public void setRefImagesFromEDT(final GraphicsConfiguration grConf) {
    if (grConf != null) {
      synchronized(this.refImageMutex) {
        this.refImageOpaque      = grConf.createCompatibleImage(1, 1, Transparency.OPAQUE);
        this.refImageTranspMask  = grConf.createCompatibleImage(1, 1, Transparency.BITMASK);
        this.refImageTranslucent = grConf.createCompatibleImage(1, 1, Transparency.TRANSLUCENT);
      }
    }
  }
  private BufferedImage getCompatibleImage(final BufferedImage refImage, final int width, final int height) {
    BufferedImage img = null;
    if (refImage != null) {
      final int grType = refImage.getType();
      if (grType == BufferedImage.TYPE_CUSTOM) {
        final ColorModel               cm = refImage.getColorModel();
        final WritableRaster           wr = cm.createCompatibleWritableRaster(width, height);
        final String[]                 ps = refImage.getPropertyNames();
        final int                      pl = (ps == null) ? 0 : ps.length;
        final Hashtable<String,Object> ph = new Hashtable<String,Object>(pl);
        for (int pi=0; pi<pl; pi++) {
          ph.put(ps[pi], refImage.getProperty(ps[pi]));
        }
        img = new BufferedImage(cm, wr, cm.isAlphaPremultiplied(), ph);
      } else {
        img = new BufferedImage(width, height, grType);
      }
    }
    return img;
  }
  public BufferedImage getCompatibleImageOpaque(final int width, final int height) {
    BufferedImage img = null;
    synchronized(this.refImageMutex) {
      img = this.getCompatibleImage(this.refImageOpaque, width, height);
    }
    return img;
  }
  public BufferedImage getCompatibleImageTranspMask(final int width, final int height) {
    BufferedImage img = null;
    synchronized(this.refImageMutex) {
      img = this.getCompatibleImage(this.refImageTranspMask, width, height);
    }
    return img;
  }
  public BufferedImage getCompatibleImageTranslucent(final int width, final int height) {
    BufferedImage img = null;
    synchronized(this.refImageMutex) {
      img = this.getCompatibleImage(this.refImageTranslucent, width, height);
    }
    return img;
  }
}