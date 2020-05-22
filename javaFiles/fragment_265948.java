import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;

public class TestLayeredPane02 {

    public static void main(String[] args) {
        new TestLayeredPane02();
    }

    public TestLayeredPane02() {
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
                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JLayeredPane {

        private JTextPane tp;

        public TestPane() {
            tp = new JTextPane();

            Reader reader = null;
            try {
                reader = new FileReader(new File("sometextfile.txt"));
                tp.read(reader, "Help");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (Exception e) {
                }
            }
            tp.setFont(UIManager.getFont("TextArea.font"));

            JScrollPane scrollPane = new JScrollPane(tp);
            scrollPane.setRowHeaderView(new LineNumberHeader(tp));

            OverLayPane overLayPane = new OverLayPane();

            add(scrollPane, new Integer(0));
            add(overLayPane, new Integer(5));

            moveToFront(overLayPane);
        }

        @Override
        public void doLayout() {
            for (Component comp : getComponents()) {
                comp.setBounds(0, 0, getWidth(), getHeight());
            }
        }

    }

    public class OverLayPane extends JPanel {

        public OverLayPane() {
            setLayout(new BorderLayout());
            try {
                BufferedImage img = ImageIO.read(new File("/path/to/image.png"));
                JLabel label = new JLabel(new ImageIcon(img.getScaledInstance(-1, 200, Image.SCALE_SMOOTH)));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                add(label);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setOpaque(false);
            setBackground(new Color(255, 0, 0, 128));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getBackground());
            g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
            g2d.dispose();
        }
    }
    public class LineNumberHeader extends JPanel {

        private JTextPane field;

        public LineNumberHeader(JTextPane field) {
            this.field = field;
            field.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    revalidate();
                    repaint();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    revalidate();
                    repaint();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    revalidate();
                    repaint();
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            int height = field.getPreferredSize().height;
            Element root = field.getDocument().getDefaultRootElement();
            int lineCount = root.getElementCount();
            FontMetrics fm = getFontMetrics(getFont());
            int width = fm.stringWidth(Integer.toString(lineCount)) + 4;
            return new Dimension(width, height);
        }

        protected void drawLineNumber(Graphics2D g2d, int line, Element element) {
            int startIndex = element.getStartOffset();
            FontMetrics fm = g2d.getFontMetrics();
            String strLine = Integer.toString(line);
            try {
                Rectangle rect = field.modelToView(startIndex);
                int strWidth = fm.stringWidth(strLine);
                g2d.drawString(strLine, getWidth() - 2 - strWidth, rect.y + fm.getAscent());
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            Element root = field.getDocument().getDefaultRootElement();
            drawLineNumber(g2d, 1, root);
            for (int index = 0; index < root.getElementCount(); index++) {
                Element element = root.getElement(index);
                drawLineNumber(g2d, index + 1, element);
            }
            g2d.dispose();
        }
    }        
}