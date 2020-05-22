import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class MandelbrotSet {
  private int numberOfIterations;
  private double realMin;
  private double realMax;
  private double imaginaryMin;
  private double imaginaryMax;
  private int width;
  private int height;
  public BufferedImage image;
  public Graphics2D imageGraphics;
  static final int nThreads = 4;

  public MandelbrotSet(int width, int height) {
    // Set the width and the height
    this.width = width;
    this.height = height;
    image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    imageGraphics = image.createGraphics();
    this.realMin = -2.0;
    this.realMax = 1;
    this.imaginaryMin = -1;
    this.imaginaryMax = 1;
    this.numberOfIterations = 1000;
  }

  public Complex calculateComplexNumber(int x, int y) {
    double realPart = realMin + x * (realMax - realMin) / (width - 1);
    double imaginaryPart = imaginaryMax - y * (imaginaryMax - imaginaryMin) / (height - 1);

    return new Complex(realPart, imaginaryPart);
  }

  public void calculateMandelbrotImagePoints() {
    Thread[] threads = new Thread[nThreads];
    int bandHeight = height / nThreads;

    for (int i = 0; i < nThreads; i++) {
      BufferedImage band = new BufferedImage(width, bandHeight, BufferedImage.TYPE_4BYTE_ABGR);
      threads[i] = new Thread(new MThread(band, i * bandHeight, bandHeight));
      threads[i].start();
    }
  }

  class MThread implements Runnable {
    final BufferedImage band;
    final Graphics2D g;
    final int top;
    final int height;

    private MThread(BufferedImage band, int top, int height) {
      this.band = band;
      g = band.createGraphics();
      this.top = top;
      this.height = height;
    }

    @Override
    public void run() {
      for (int x = 0; x < width; x++) {
        for (int y = top; y < top + height; y++) {
          int n = 0;
          Complex c = calculateComplexNumber(x, y);
          Complex z = c;

          while ((z.times(z).mod() < 4.0D) && (n < numberOfIterations)) {
            z = z.times(z).plus(c);
            n++;
          }

          if (n == numberOfIterations) {
            g.setColor(Color.BLACK);
          } else {
            g.setColor(Color.getHSBColor(n / 100.0F, 1, 1));
          }
          g.drawLine(x, y-top, x, y-top);
        }
      }
      // Do somehing to merge this band ino the main one.
      // Not familiar with java graphics so this may be wrong.
      imageGraphics.drawImage(band, null, 0, top);
    }
  }

}