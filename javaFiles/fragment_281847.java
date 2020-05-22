import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class SideScroller extends JPanel {

    private Random random = new Random();
    private int r, g, b;
    private int x = 0, y = 0;

    public SideScroller() {
        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();
        im.put(KeyStroke.getKeyStroke("UP"), "upaction");
        am.put("upaction", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                y -= 5;

                repaint();
            }
        });
        im.put(KeyStroke.getKeyStroke("DOWN"), "downaction");
        am.put("downaction", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                y += 5;
                repaint();
            }
        });
        im.put(KeyStroke.getKeyStroke("LEFT"), "leftaction");
        am.put("leftaction", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                x -= 5;
                repaint();
            }
        });
        im.put(KeyStroke.getKeyStroke("RIGHT"), "rightaction");
        am.put("rightaction", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                x += 5;
                repaint();
            }
        });
    }

    protected void paintComponent(Graphics gg) {
        super.paintComponent(gg);

        gg.setColor(new Color(r, g, b));
        gg.fillRect(x, y, 50, 50);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame();

                f.add(new SideScroller());
                f.setSize(500, 500);
                f.setLocationRelativeTo(null);
                f.setResizable(false);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}