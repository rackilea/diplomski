import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.net.*;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

class TileSetUtility {

    /** Divide the tile into tiles based on the number of cols & rows 
     * supplied.  Exclude any images that are a solid color. */
    public static ArrayList<BufferedImage> getTiles(
            BufferedImage tile, int cols, int rows) {
        int w = tile.getWidth();
        int h = tile.getHeight();
        int wT = w / cols;
        int hT = h / rows;
        if (wT * cols != w || hT * rows != h) {
            throw new IllegalArgumentException("Tile is not an even " +
                    "multiple of pixels of WxCols or HxRows!");
        }
        ArrayList<BufferedImage> tiles = new ArrayList<BufferedImage>();
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                BufferedImage i = tile.getSubimage(x * wT, y * hT, wT, hT);
                if (!isImageSolidColor(i)) {
                    tiles.add(i);
                }
            }
        }
        return tiles;
    }

    /** Takes an image that represents tiles of a tile set, and infers the 
     * number of columns based on the assumption that the color at 0x0 in the 
     * image represents a border color or frame for the contained tiles. */
    public static int inferNumberColumns(BufferedImage img) {
        boolean[] columnClear = new boolean[img.getWidth()];
        // after this loop, we should have a series of contiguous regions
        // of 'true' in the array.
        for (int ii = 0; ii < columnClear.length; ii++) {
            columnClear[ii] = isLineEmpty(img, ii, false);
        }
        return countContiguousRegions(columnClear);
    }

    /** Takes an image that represents tiles of a tile set, and infers the 
     * number of rows based on the assumption that the color at 0x0 in the 
     * image represents a border color or frame for the contained tiles. */
    public static int inferNumberRows(BufferedImage img) {
        boolean[] columnClear = new boolean[img.getHeight()];
        // after this loop, we should have a series of contiguous regions
        // of 'true' in the array.
        for (int ii = 0; ii < columnClear.length; ii++) {
            columnClear[ii] = isLineEmpty(img, ii, true);
        }
        return countContiguousRegions(columnClear);
    }

    /** Count the number of contiguous regions of 'true' */
    public static int countContiguousRegions(boolean[] array) {
        boolean newRegion = false;
        int count = 0;
        for (boolean bool : array) {
            if (bool) {
                if (newRegion) {
                    count++;
                }
                newRegion = false;
            } else {
                newRegion = true;
            }
        }
        return count;
    }

    /** Determine if this entire column or row of image pixels is empty. */
    public static boolean isLineEmpty(
            BufferedImage img, int pos, boolean row) {

        if (!row) {
            for (int y = 0; y < img.getHeight(); y++) {
                if (img.getRGB(pos, y) != img.getRGB(0, 0)) {
                    return false;
                }
            }
        } else {
            for (int x = 0; x < img.getWidth(); x++) {
                if (img.getRGB(x, pos) != img.getRGB(0, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    /** Determine if this image is one solid color (implies redundant tile) */
    public static boolean isImageSolidColor(BufferedImage img) {
        int c = img.getRGB(0,0);
        for (int x=0; x<img.getWidth(); x++) {
            for (int y=0; y<img.getHeight(); y++) {
                if (c!=img.getRGB(x,y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://i.stack.imgur.com/ttXm6.png");
        final BufferedImage tileSet = ImageIO.read(url);
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel gui = new JPanel(new BorderLayout(5, 5));

                int cols = inferNumberColumns(tileSet);
                System.out.println("tileSet cols: " + cols);
                int rows = inferNumberRows(tileSet);
                System.out.println("tileSet rows: " + rows);

                ArrayList<BufferedImage> tiles = getTiles(tileSet, cols, rows);
                JPanel p = new JPanel(new GridLayout(0, 7, 1, 1));
                for (BufferedImage tile : tiles) {
                    JLabel l = new JLabel(new ImageIcon(tile));
                    l.setBorder(new LineBorder(Color.BLACK));
                    p.add(l);
                }

                gui.add(new JLabel(new ImageIcon(tileSet)));

                JOptionPane.showMessageDialog(null, p);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        SwingUtilities.invokeLater(r);
    }
}