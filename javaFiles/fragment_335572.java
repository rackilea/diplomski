import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static java.lang.Math.abs;
import static java.lang.Math.min;

public class SeamCarving {

    public static void main(String[] args) {
        new SeamCarving();
    }

    public SeamCarving() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage input;
        BufferedImage[] toPaint;

        public TestPane() {
            try {

                input = ImageIO.read(new File("..."));
                toPaint = new BufferedImage[]{input};

                toPaint = new BufferedImage[1];
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            setLayout(new GridBagLayout());
            JButton loadButton = new JButton("Load");
            loadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BufferedImage out = input;
                    toPaint[0] = input;
                    repaint();
                    System.out.println("Do Something Clicked");
                }
            });
            add(loadButton);
            JButton startButton = new JButton("Start");

            add(startButton);
            startButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    BufferedImage out = deleteVerticalSeam(toPaint[0]);
                    System.out.println("Do Something Clicked");
                    toPaint[0] = out;
                    repaint();
                }
            });

        }

        @Override
        public Dimension getPreferredSize() {
            return input == null ? super.getPreferredSize() : new Dimension(input.getWidth(), input.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(toPaint[0], 0, 0, this);
            g2d.dispose();
        }

    }

    private static BufferedImage deleteVerticalSeam(BufferedImage input) {
        return deleteVerticalSeam(input, findVerticalSeam(input));
    }

    private static BufferedImage deleteVerticalSeam(final BufferedImage input, final int[] seam) {
        int w = input.getWidth(), h = input.getHeight();
        final BufferedImage out = new BufferedImage(w - 1, h, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < seam[y]; x++) {
                out.setRGB(x, y, input.getRGB(x, y));
            }
            for (int x = seam[y] + 1; x < w; x++) {
                out.setRGB(x - 1, y, input.getRGB(x, y));
            }
        }
        return out;
    }

    private static int[] findVerticalSeam(BufferedImage input) {
        final int w = input.getWidth(), h = input.getHeight();
        final FloatImage intensities = FloatImage.fromBufferedImage(input);
        final FloatImage energy = computeEnergy(intensities);

        final FloatImage minima = FloatImage.createSameSize(energy);
        //First row is equal to the energy
        for (int x = 0; x < w; x++) {
            minima.set(x, 0, energy.get(x, 0));
        }

        //I assume that the rightmost pixel column in the energy image is garbage
        for (int y = 1; y < h; y++) {
            minima.set(0, y, energy.get(0, y) + min(minima.get(0, y - 1),
                    minima.get(1, y - 1)));

            for (int x = 1; x < w - 2; x++) {
                final float sum = energy.get(x, y) + min(min(minima.get(x - 1, y - 1),
                        minima.get(x, y - 1)), minima.get(x + 1, y - 1));
                minima.set(x, y, sum);
            }
            minima.set(w - 2, y, energy.get(w - 2, y) + min(minima.get(w - 2, y - 1), minima.get(w - 3, y - 1)));
        }

        //We find the minimum seam
        float minSum = Float.MAX_VALUE;
        int seamTip = -1;
        for (int x = 1; x < w - 1; x++) {
            final float v = minima.get(x, h - 1);
            if (v < minSum) {
                minSum = v;
                seamTip = x;
            }
        }

        //Backtrace the seam
        final int[] seam = new int[h];
        seam[h - 1] = seamTip;
        for (int x = seamTip, y = h - 1; y > 0; y--) {
            float left = x > 0 ? minima.get(x - 1, y - 1) : Float.MAX_VALUE;
            float up = minima.get(x, y - 1);
            float right = x + 1 < w ? minima.get(x + 1, y - 1) : Float.MAX_VALUE;
            if (left < up && left < right) {
                x = x - 1;
            } else if (right < up && right < left) {
                x = x + 1;
            }
            seam[y - 1] = x;
        }

        return seam;
    }

    private static FloatImage computeEnergy(FloatImage intensities) {
        int w = intensities.getWidth(), h = intensities.getHeight();
        final FloatImage energy = FloatImage.createSameSize(intensities);
        for (int x = 0; x < w - 1; x++) {
            for (int y = 0; y < h - 1; y++) {
                //I'm aproximating the derivatives by subtraction
                float e = abs(intensities.get(x, y) - intensities.get(x + 1, y))
                        + abs(intensities.get(x, y) - intensities.get(x, y + 1));
                energy.set(x, y, e);
            }
        }
        return energy;
    }

    public static final class FloatImage {

        private final int width;
        private final int height;
        private final float[] data;

        public FloatImage(int width, int height) {
            this.width = width;
            this.height = height;
            this.data = new float[width * height];
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public float get(final int x, final int y) {
            if (x < 0 || x >= width) {
                throw new IllegalArgumentException("x: " + x);
            }
            if (y < 0 || y >= height) {
                throw new IllegalArgumentException("y: " + y);
            }
            return data[x + y * width];
        }

        public void set(final int x, final int y, float value) {
            if (x < 0 || x >= width) {
                throw new IllegalArgumentException("x: " + x);
            }
            if (y < 0 || y >= height) {
                throw new IllegalArgumentException("y: " + y);
            }
            data[x + y * width] = value;
        }

        public static FloatImage createSameSize(final BufferedImage sample) {
            return new FloatImage(sample.getWidth(), sample.getHeight());
        }

        public static FloatImage createSameSize(final FloatImage sample) {
            return new FloatImage(sample.getWidth(), sample.getHeight());
        }

        public static FloatImage fromBufferedImage(final BufferedImage src) {
            final int width = src.getWidth();
            final int height = src.getHeight();
            final FloatImage result = new FloatImage(width, height);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    final int argb = src.getRGB(x, y);
                    int r = (argb >>> 16) & 0xFF;
                    int g = (argb >>> 8) & 0xFF;
                    int b = argb & 0xFF;
                    result.set(x, y, (r * 0.3f + g * 0.59f + b * 0.11f) / 255);
                }
            }
            return result;
        }

        public BufferedImage toBufferedImage(float scale) {
            final BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    final int intensity = ((int) (get(x, y) * scale)) & 0xFF;
                    result.setRGB(x, y, 0xFF000000 | intensity | intensity << 8 | intensity << 16);
                }
            }
            return result;
        }
    }
}