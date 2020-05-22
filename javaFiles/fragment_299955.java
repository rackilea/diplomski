import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.Scrollable;

public class Main {

    public static void main(String[] args) {

        String s = "Hello my name is test. I am a test. Hello my name is test. I am a test. Hello my name is test. I am a test. Hello my name is test. I am a test. ";
        JFrame jf = new JFrame("Test");
        jf.setSize(600, 200);

        BigPane big = new BigPane();
        big.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;

        for (int i = 0; i < 2; i++) {
            JPanel first = new JPanel(new BorderLayout());

            JPanel insideTop = new JPanel(new GridLayout(2, 2));
            insideTop.add(new JLabel("test"));
            insideTop.add(new JLabel("test"));
            insideTop.add(new JLabel("test"));
            insideTop.add(new JLabel("test"));

            JPanel insideMiddle = new JPanel(new BorderLayout());
            insideMiddle.add(new JLabel("Description"), BorderLayout.NORTH);
            JTextArea jta = new JTextArea(s);
            jta.setWrapStyleWord(true);
            jta.setLineWrap(true);
            jta.setEditable(false);
            jta.setFocusable(false);
            jta.setOpaque(false);
            insideMiddle.add(jta, BorderLayout.CENTER);

            JPanel insideBottom = new JPanel(new BorderLayout());
            insideBottom.add(new JLabel("Bottom left"), BorderLayout.WEST);
            insideBottom.add(new JButton("Bottom right"), BorderLayout.EAST);

            first.add(insideTop, BorderLayout.NORTH);
            first.add(insideMiddle, BorderLayout.CENTER);
            first.add(insideBottom, BorderLayout.SOUTH);
            big.add(first, gbc);
        }

        JScrollPane scrollPane = new JScrollPane(big, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jf.add(scrollPane);
        jf.setVisible(true);

    }

    public static class BigPane extends JPanel implements Scrollable {

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(200, 200);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            boolean track = true;
            Container parent = getParent();
            if (parent instanceof JViewport) {

                JViewport viewport = (JViewport) parent;
                if (viewport.getHeight() < getPreferredSize().height) {
                    track = false;
                }

            }

            return track;
        }

    }
}