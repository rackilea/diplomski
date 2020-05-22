import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class UnicodeText {
public static void main(String[] args) {
JFrame f = new JFrame() {
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    Font font = new Font("Bravura", Font.PLAIN, 32);

    g2.setFont(font);
    g2.drawString("\uD834\uDD1E", 40, 80);// Gclef
    g2.drawString("\uD834\uDD22", 40, 80);// Fclef
  }
};
f.setSize(200,200);
f.setVisible(true);
}
}