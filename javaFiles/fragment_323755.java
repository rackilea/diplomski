import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JavaApplication254 {

    public static void main(String[] args) {
        new JavaApplication254();
    }

    public JavaApplication254() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JButton btn = new JButton("Click me away...");
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        TestPane testPane = new TestPane();
                        SnapshotAction snapshotAction = new SnapshotAction(testPane);

                        JMenuBar mb = new JMenuBar();
                        JMenu mnuFile = new JMenu("File");
                        mnuFile.add(snapshotAction);
                        mb.add(mnuFile);

                        JFrame frame = new JFrame("More Testing");
                        frame.setJMenuBar(mb);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.add(testPane);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(btn);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setBorder(new EmptyBorder(20, 20, 20, 20));
            JLabel label = new JLabel("I be a bananan");
            label.setOpaque(true);
            label.setBackground(Color.YELLOW);
            label.setForeground(Color.RED);
            label.setBorder(
                    new CompoundBorder(
                            new LineBorder(Color.RED),
                            new EmptyBorder(20, 20, 20, 20)));
            setLayout(new GridBagLayout());
            add(label);
        }

    }

    public class SnapshotAction extends AbstractAction {

        private JComponent parent;

        public SnapshotAction(JComponent parent) {
            this.parent = parent;
            putValue(NAME, "Take Snapshot...");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (parent.isDisplayable()) {

                BufferedImage img = new BufferedImage(parent.getWidth(), parent.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = img.createGraphics();
                parent.printAll(g2d);
                g2d.dispose();

                try {
                    ImageIO.write(img, "png", new File("Snapshot.png"));
                    Toolkit.getDefaultToolkit().beep();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(parent, "Failed to generate snapshot: " + ex.getMessage());
                }

            }
        }

    }

}