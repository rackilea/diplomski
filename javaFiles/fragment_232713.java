import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultListModel<String> model = new DefaultListModel<>();
                model.addElement("Bananas");
                model.addElement("Apples");
                model.addElement("Pears");
                model.addElement("Grapes");
                model.addElement("Tim Tams");

                JList list = new JList(model);
                list.setCellRenderer(new DefaultListCellRenderer() {

                    @Override
                    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        setOpaque(isSelected);
                        return this;
                    }

                });
                list.setOpaque(false);
                JScrollPane sp = new JScrollPane(list);
                sp.setOpaque(false);
                sp.getViewport().setOpaque(false);

                TranslucentPane tp = new TranslucentPane();
                tp.setLayout(new GridBagLayout());
                tp.setLayout(new BorderLayout());
                tp.add(sp);

                JFrame frame = new JFrame("Testing");
                frame.setContentPane(new BackgroundPane());
                frame.setLayout(new GridBagLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(tp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TranslucentPane extends JPanel {

        private float alpha = 0.75f;

        public TranslucentPane() {
            setOpaque(false);
            setBorder(new EmptyBorder(5, 5, 5, 5));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));

            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }

    }

    public class BackgroundPane extends JPanel {

        private BufferedImage background;

        public BackgroundPane() {
            try {
                background = ImageIO.read(new File("C:\\Users\\shane\\Dropbox\\MegaTokyo\\thumnails\\megatokyo_omnibus_1_3_cover_by_fredrin-d4oupef.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(background.getWidth(), background.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = (getWidth() - background.getWidth()) / 2;
            int y = (getHeight() - background.getHeight()) / 2;
            g.drawImage(background, x, y, this);
        }

    }

}