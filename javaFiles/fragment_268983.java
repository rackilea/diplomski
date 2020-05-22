import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Code39 {
    private static final int BARCODE_LINE_WIDTH = 5;
    private static final int BARCODE_HEIGHT = 100;

    public static void main(String[] args) throws IOException {
        Code39 code39 = new Code39("123456789");
        int[] barcode = code39.barcode();
        int width = BARCODE_LINE_WIDTH * barcode.length;
        int height = BARCODE_HEIGHT;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        for (int i = 0; i < barcode.length; i++) {
            if (barcode[i] == 0) {
                g2d.setColor(Color.WHITE);
            } else {
                g2d.setColor(Color.BLACK);
            }
            g2d.fillRect(i * BARCODE_LINE_WIDTH, 0, BARCODE_LINE_WIDTH, height);
        }

        g2d.dispose();
        RenderedImage rendImage = bufferedImage;

        File file = new File("newimage.png");
        ImageIO.write(rendImage, "png", file);
    }

    private String code;
    private int[] bars;

    public Code39(String code) {
        this.code = code.toUpperCase().trim();

        bars = new int[(code.length() + 2) * 12];

        this.buildSequence();
    }

    public void buildSequence() {
        String encoded = "*" + code + "*";

        int p = 0;
        for (int i = 0; i < encoded.length(); i++) {
            int[] sequence = mapSequence(encoded.charAt(i), i);
            System.arraycopy(sequence, 0, bars, p, sequence.length);
            p += sequence.length;
        }
    }

    public int[] mapSequence(char c, int pos) {
        HashMap<Character, int[]> sequence = new HashMap<Character, int[]>();

        sequence.put('0', new int[]{1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1});
        sequence.put('1', new int[]{1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1});
        sequence.put('2', new int[]{1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1});
        sequence.put('3', new int[]{1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1});
        sequence.put('4', new int[]{1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1});
        sequence.put('5', new int[]{1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1});
        sequence.put('6', new int[]{1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1});
        sequence.put('7', new int[]{1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1});
        sequence.put('8', new int[]{1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1});
        sequence.put('9', new int[]{1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1});
        sequence.put('A', new int[]{1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1});
        sequence.put('B', new int[]{1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1});
        sequence.put('C', new int[]{1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1});
        sequence.put('D', new int[]{1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1});
        sequence.put('E', new int[]{1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1});
        sequence.put('F', new int[]{1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1});
        sequence.put('G', new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1});
        sequence.put('H', new int[]{1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1});
        sequence.put('I', new int[]{1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1});
        sequence.put('J', new int[]{1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1});
        sequence.put('K', new int[]{1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1});
        sequence.put('L', new int[]{1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1});
        sequence.put('M', new int[]{1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1});
        sequence.put('N', new int[]{1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1});
        sequence.put('O', new int[]{1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1});
        sequence.put('P', new int[]{1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1});
        sequence.put('Q', new int[]{1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1});
        sequence.put('R', new int[]{1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1});
        sequence.put('S', new int[]{1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1});
        sequence.put('T', new int[]{1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1});
        sequence.put('U', new int[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1});
        sequence.put('V', new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1});
        sequence.put('W', new int[]{1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1});
        sequence.put('X', new int[]{1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1});
        sequence.put('Y', new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1});
        sequence.put('Z', new int[]{1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1});
        sequence.put('-', new int[]{1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1});
        sequence.put('.', new int[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1});
        sequence.put(' ', new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1});
        sequence.put('$', new int[]{1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1});
        sequence.put('/', new int[]{1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1});
        sequence.put('+', new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1});
        sequence.put('%', new int[]{1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1});
        sequence.put('*', new int[]{1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1});

        return sequence.get(c);
    }

    public int[] barcode() {
        return bars;
    }

    public String code() {
        return code;
    }

    public int calculateCheckDigit() {
        return 0;
    }
}