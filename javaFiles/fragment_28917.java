import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicScrollBarUI;
public class Main
{
    public static void main (String [] a) {
        SwingUtilities.invokeLater (new Runnable () {
            @Override public void run () {
                try {
                    UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
                    createAndShowGUI ();
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog (null, "An unexpected error occurred : " + e.getClass ().getSimpleName (), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    private static void createAndShowGUI () {
        JFrame frame = new JFrame ("Test ScrollBar");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setContentPane (new CustomScrollPane ());
        frame.pack ();
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
}
class CustomScrollPane extends JScrollPane
{
    public CustomScrollPane () {
        super (VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_ALWAYS);
        Image imageThumb = createImage (16, 16, Color.RED);
        Image imageThumbPressed = createImage (16, 16, Color.MAGENTA);
        Image imageTrack = createImage (16, 16, Color.YELLOW);
        // Adding some test labels
        JPanel view = new JPanel (new GridLayout (10, 5, 20, 50));
        for (int i = 0; i < 50; i++) view.add (new JLabel ("Test Label " + String.valueOf (i)));
        setViewportView (view);
        setHorizontalScrollBar (new CustomScrollBar (JScrollBar.HORIZONTAL, imageThumb, imageThumbPressed, imageTrack));
        setVerticalScrollBar (new CustomScrollBar (JScrollBar.VERTICAL, imageThumb, imageThumbPressed, imageTrack));
        // Setting preferred size for convenience. Not a good practice !
        setPreferredSize (new Dimension (200, 200));
    }
    private Image createImage (int width, int height, Color color) {
        BufferedImage image = new BufferedImage (width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics ();
        g.setColor (color);
        g.fillRect (0, 0, width, height);
        g.dispose ();
        return image;
    }
}
class CustomScrollBar extends JScrollBar
{
    private boolean isThumbPressed;

    public CustomScrollBar (final int orientation, final Image thumb, final Image thumbPressed, final Image track) { 
        super (orientation);
        addMouseListener (new MouseAdapter () {
            public void mousePressed (MouseEvent e) {
                isThumbPressed = true;
            }
            public void mouseReleased (MouseEvent e) {
                isThumbPressed = false;
            }
        });
        setUI (new BasicScrollBarUI () {
            @Override protected void paintThumb (Graphics g, JComponent c, Rectangle r) {
                if (isThumbPressed) g.drawImage (thumbPressed, r.x, r.y, r.width, r.height, null);
                else g.drawImage (thumb, r.x, r.y, r.width, r.height, null);
            }
            @Override protected void paintTrack (Graphics g, JComponent c, Rectangle r) {
                g.drawImage(track, r.x, r.y, r.width, r.height, null);
            }
        });
    }
}