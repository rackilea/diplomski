import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TransparentButton {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                MyButton button = null;

                try {
                    button = new MyButton(scaleImage(100, 100, ImageIO.read(new URL("http://2.bp.blogspot.com/-eRryNji1gQU/UCIPw0tY5bI/AAAAAAAASt0/qAvERbom5N4/s1600/original_smiley_face.png"))));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        super.mouseClicked(me);
                        MyButton mb = ((MyButton) me.getSource());
                        if (!isAlpha(mb.getIconImage(), me.getX(), me.getY())) {
                            JOptionPane.showMessageDialog(frame, "You clicked the smiley");
                        }
                    }

                    private boolean isAlpha(BufferedImage bufImg, int posX, int posY) {
                        int alpha = (bufImg.getRGB(posX, posY) >> 24) & 0xFF;
                        return alpha == 0;
                    }
                });

                frame.add(button);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static BufferedImage scaleImage(int w, int h, Image img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        return bi;
    }
}

class MyButton extends JButton {

    BufferedImage icon;

    MyButton(BufferedImage bi) {
        this.icon = ((BufferedImage) bi);
        setContentAreaFilled(false);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(icon.getWidth(), icon.getHeight());
    }

    public BufferedImage getIconImage() {
        return icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon, 0, 0, this);
    }
}