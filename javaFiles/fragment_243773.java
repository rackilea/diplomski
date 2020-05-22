package mcve;

import javax.swing.*;
import java.awt.*;

public class WindowPlacement {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Window Placement");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton top = new JButton("Top");
            JButton left = new JButton("Left");
            JButton bottom = new JButton("Bottom");
            JButton right = new JButton("Right");

            frame.add(top, BorderLayout.NORTH);
            frame.add(left, BorderLayout.WEST);
            frame.add(bottom, BorderLayout.SOUTH);
            frame.add(right, BorderLayout.EAST);

            top.addActionListener(e -> setLocationToTop(frame));
            left.addActionListener(e -> setLocationToLeft(frame));
            bottom.addActionListener(e -> setLocationToBottom(frame));
            right.addActionListener(e -> setLocationToRight(frame));

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    // Also see:
    // https://docs.oracle.com/javase/9/docs/api/java/awt/GraphicsEnvironment.html#getMaximumWindowBounds--
    static Rectangle getMaxWindowBounds(JFrame frame) {
        GraphicsConfiguration config = frame.getGraphicsConfiguration();
        Rectangle bounds = config.getBounds();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
        bounds.x += insets.left;
        bounds.y += insets.top;
        bounds.width -= insets.left + insets.right;
        bounds.height -= insets.top + insets.bottom;
        return bounds;
    }

    static void setLocationToTop(JFrame frame) {
        frame.setLocation(frame.getX(), getMaxWindowBounds(frame).y);
    }

    static void setLocationToLeft(JFrame frame) {
        frame.setLocation(getMaxWindowBounds(frame).x, frame.getY());
    }

    static void setLocationToBottom(JFrame frame) {
        Rectangle bounds = getMaxWindowBounds(frame);
        frame.setLocation(frame.getX(), bounds.y + bounds.height - frame.getHeight());
    }

    static void setLocationToRight(JFrame frame) {
        Rectangle bounds = getMaxWindowBounds(frame);
        frame.setLocation(bounds.x + bounds.width - frame.getWidth(), frame.getY());
    }
}