import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ScrollBarDemo2 extends JFrame {
    private static final long serialVersionUID = -3189856074534869132L;

    private JScrollBar jscbHorizontal = new JScrollBar(JScrollBar.HORIZONTAL);
    private JScrollBar jscbVertical = new JScrollBar(JScrollBar.VERTICAL);

    private JTextField jtfMessage = new JTextField("Example String");

    private MessagePanel messagePanel = new MessagePanel(jtfMessage.getText());

    public ScrollBarDemo2() {
        // Add components to the frame
        add(messagePanel, BorderLayout.CENTER);
        add(jscbHorizontal, BorderLayout.SOUTH);
        add(jscbVertical, BorderLayout.EAST);
        add(jtfMessage, BorderLayout.NORTH);

        // Register listener to scroll bars
        ScrollBarListener jscbListener = new ScrollBarListener();
        jscbHorizontal.addAdjustmentListener(jscbListener);
        jscbVertical.addAdjustmentListener(jscbListener);

        // Register a listener in text field
        jtfMessage.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                messagePanel.setText(jtfMessage.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                messagePanel.setText(jtfMessage.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                messagePanel.setText(jtfMessage.getText());
            }
        });

    }

    private class ScrollBarListener implements AdjustmentListener {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            // Determine the orientation of the event source
            JScrollBar scrollBar = (JScrollBar) e.getAdjustable();

            if (scrollBar.getOrientation() == JScrollBar.HORIZONTAL) {
                // Obtain the horizontal space remaining
                double spaceAvailable = (double) messagePanel
                        .getHorizontalEmptySpace();

                // Find how much to scale each value of the scroll bars (since
                // we're using the default 100 total values)
                double scaledValue = (scrollBar.getValue() * spaceAvailable / (double) scrollBar
                        .getMaximum());

                // Set new x coordinate
                messagePanel.setMessageX((int) scaledValue);
            } else if (scrollBar.getOrientation() == JScrollBar.VERTICAL) {
                // Obtain the vertical space remaining
                double spaceAvailable = (double) messagePanel
                        .getVerticalEmptySpace();

                // Find how much to scale each value of the scroll bars (since
                // we're using the default 100 total values)
                double scaledValue = (scrollBar.getValue() / (double) scrollBar
                        .getMaximum()) * spaceAvailable;

                // Set new x coordinate
                messagePanel.setMessageY((int) scaledValue);
            }
        }
    }

    /** main method **/
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ScrollBarDemo2 frame = new ScrollBarDemo2();
                frame.setTitle("Scroll Bar Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}

class MessagePanel extends JPanel {
    private static final long serialVersionUID = -2743160276473942475L;

    private FontMetrics fm;
    private String message = "";
    private int messageX = -1;
    private int messageY = -1;

    public MessagePanel() {
        this("Welcome to Java");
    }

    public MessagePanel(String message) {
        this.message = message;
        this.setPreferredSize(new Dimension(500, 200));
    }

    public void moveRight() {
        messageX += getWidth() / 50;
        repaint();
    }

    public void moveLeft() {
        messageX -= getWidth() / 50;
        repaint();
    }

    public void moveUp() {
        messageY -= getHeight() / 100;
        repaint();
    }

    public void moveDown() {
        messageY += getHeight() / 100;
        repaint();
    }

    public int getMessageX() {
        return messageX;
    }

    public int getMessageY() {
        return messageY;
    }

    public void setMessageX(int x) {
        messageX = x;
        repaint();

    }

    public void setMessageY(int y) {
        messageY = y;
        repaint();
    }

    public void setText(String newMessage) {
        message = newMessage;
        repaint();
    }

    public int getVerticalEmptySpace() {
        return getHeight() - fm.getAscent();
    }

    public int getHorizontalEmptySpace() {
        return getWidth() - fm.stringWidth(message);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (messageX < 0 && messageY < 0) { // Check to initialize centered
                                            // position
            fm = g.getFontMetrics();

            messageX = getWidth() - fm.stringWidth(message); // Manually setting
                                                                // it to the
                                                                // very end
                                                                // coordinate
            messageY = getHeight() / 2 - fm.getAscent() / 2;
        }

        g.drawString(message, messageX, messageY);

    }
}