import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.Override;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

public class Test extends JFrame {

    public Test() {
        super("Test overflowing label");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setSize(300, 200);
        createUI();
    }

    private void createUI() {
        JLabel label2 = new JLabel();
        JLabel label1 = new OverflowingLabel("text to truncate since it's too long ...", label2);

        final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, label1, label2);
        splitPane.setDividerSize(2);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                splitPane.setDividerLocation(.5d);
            }
        });

        setContentPane(splitPane);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test test = new Test();
                test.setVisible(true);
            }
        });
    }

    private class OverflowingLabel extends JLabel  {

        private JLabel[] dependantLabels;

        public OverflowingLabel(String text, JLabel... dependantLabels) {
            super(text);
            this.dependantLabels = dependantLabels;

            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    overflowText();
                }

                @Override
                public void componentResized(ComponentEvent e) {
                    overflowText();
                }
            });
        }

        private void overflowText() {
            int index = getIndexToChopText();

            String text = getText().substring(index);

            for (JLabel dependantLabel : dependantLabels)
                dependantLabel.setText(text);
        }

        private int getIndexToChopText() {
            Dimension size = getSize();
            FontMetrics metrics = getFontMetrics(getFont());
            String text = getText();

            int index = 0;
            int width = 0;

            while ((index < text.length()) && (width < size.width)) {
                int charWidth = metrics.charWidth(text.charAt(index));

                if ((width + charWidth) > size.width)
                    break;

                index ++;
                width += charWidth;
            }

            return index;
        }

        @Override
        public Dimension getMinimumSize() {
            Dimension size = super.getMinimumSize();
            return new Dimension(0, size.height);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D)g.create();
            Rectangle clip = g2d.getClipBounds();

            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            g2d.setColor(getBackground());
            g2d.fillRect(clip.x, clip.y, clip.width, clip.height);
            g2d.setColor(getForeground());
            g2d.setFont(getFont());

            FontMetrics metrics = g2d.getFontMetrics();
            int baseLine = metrics.getAscent() + metrics.getLeading();

            int index = getIndexToChopText();

            g2d.drawString(getText().substring(0, index), 0, (getHeight() + baseLine) / 2 - 1);

            g2d.dispose();
        }
    }
}