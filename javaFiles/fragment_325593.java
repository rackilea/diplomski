import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {

    public void print(BufferedImage img, int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(img.getRGB(x, y) + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Main app = new Main();

        // create input image
        int inputWidth = 2;
        int inputHeight = 2;
        BufferedImage inputImg = new BufferedImage(inputWidth, inputHeight, BufferedImage.TYPE_INT_ARGB);

        // fill input image
        System.out.println(inputWidth + "x" + inputHeight);
        Color color = Color.RED;
        for (int y = 0; y < inputHeight; y++) {
            for (int x = 0; x < inputWidth; x++) {
                int rgb = y * inputWidth * (1 << 16) + x;
                inputImg.setRGB(x, y, new Color(rgb).getRGB());
            }
        }

        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(inputImg)));

        // print
        app.print(inputImg, inputWidth, inputHeight);

        // create output image
        int outputWidth = 4;
        int outputHeight = 4;
        BufferedImage outputImg = new BufferedImage(outputWidth, outputHeight, BufferedImage.TYPE_INT_ARGB);

        // draw inputImg into outputImg
        Graphics2D g = outputImg.createGraphics();
        g.drawImage(inputImg, 0, 0, outputImg.getWidth(), outputImg.getHeight(), 0, 0, inputImg.getWidth(), inputImg.getHeight(), null);
        g.dispose();
        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(outputImg)));

        // print
        app.print(outputImg, outputImg.getWidth(), outputImg.getHeight());
    }
}