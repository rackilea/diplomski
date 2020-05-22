package mcve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class MouseoverPanels2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseoverPanels2::new);
    }

    MouseoverPanels2() {
        JFrame frame = new JFrame("Mouseover Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.WHITE);

        buttons.add(new MouseoverLabel("Queen",  QUEEN_IMG,  QUEEN_IMG_H));
        buttons.add(new MouseoverLabel("King",   KING_IMG,   KING_IMG_H));
        buttons.add(new MouseoverLabel("Rook",   ROOK_IMG,   ROOK_IMG_H));
        buttons.add(new MouseoverLabel("Knight", KNIGHT_IMG, KNIGHT_IMG_H));
        buttons.add(new MouseoverLabel("Pawn",   PAWN_IMG,   PAWN_IMG_H));

        frame.setContentPane(buttons);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class MouseoverLabel extends JComponent {
        final JLabel label;
        final Image image, hover;

        final Dimension imageMaxSize;

        boolean isHovering = false;

        MouseoverLabel(String text, Image image, Image hover) {
            setLayout(new BorderLayout());
            setOpaque(false);

            this.image = Objects.requireNonNull(image);
            this.hover = Objects.requireNonNull(hover);

            imageMaxSize =
                new Dimension(Math.max(image.getWidth(this), hover.getWidth(this)),
                              Math.max(image.getHeight(this), hover.getHeight(this)));

            label = new JLabel(text);
            label.setForeground(Color.RED);
            label.setOpaque(false);
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label, BorderLayout.CENTER);

            MouseoverListener ml = new MouseoverListener();

            addMouseListener(ml);
            label.addMouseListener(ml);
        }

        private Dimension getMax(Dimension size) {
            size.width = Math.max(size.width, imageMaxSize.width);
            size.height = Math.max(size.height, imageMaxSize.height);
            return size;
        }

        @Override
        public Dimension getPreferredSize() {
            return getMax(super.getPreferredSize());
        }
        @Override
        public Dimension getMinimumSize() {
            return getMax(super.getMinimumSize());
        }
        @Override
        public Dimension getMaximumSize() {
            return getMax(super.getMaximumSize());
        }

        @Override
        protected void paintChildren(Graphics g) {
            // Note that the label is always "visible",
            // so it will e.g. receive mouse events even
            // while we aren't painting it.
            // If the label needs to receive, say, mouse
            // clicks, then you need to check isHovering
            // in the mouse click listener.
            // If the label is a JButton, then you could
            // call button.setEnabled(isHovering) in the
            // MouseoverListener.
            if (isHovering) {
                paintImage(g, hover);
                super.paintChildren(g);
            } else {
                paintImage(g, image);
            }
        }

        private void paintImage(Graphics g, Image image) {
            int w = image.getWidth(this);
            int h = image.getHeight(this);
            int x = (getWidth() - w) / 2;
            int y = (getHeight() - h) / 2;
            g.drawImage(image, x, y, w, h, this);
        }

        class MouseoverListener extends MouseAdapter {
            @Override
            public void mouseEntered(MouseEvent e) {
                recomputeView(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                recomputeView(e);
            }
            void recomputeView(MouseEvent e) {
                Component comp = e.getComponent();
                Point     loc  = SwingUtilities.convertPoint(comp, e.getPoint(), MouseoverLabel.this);
                isHovering     = contains(loc);
                repaint();
            }
        }
    }

    static final Image QUEEN_IMG,
                       QUEEN_IMG_H,
                       KING_IMG,
                       KING_IMG_H,
                       ROOK_IMG,
                       ROOK_IMG_H,
                       KNIGHT_IMG,
                       KNIGHT_IMG_H,
                       PAWN_IMG,
                       PAWN_IMG_H;
    static {
        try {
            // source for sprite sheet: https://stackoverflow.com/a/19209651/2891664
            BufferedImage sprites = ImageIO.read(new URL("https://i.stack.imgur.com/memI0.png"));
            int n = 64;
            QUEEN_IMG    = sprites.getSubimage(0 * n, 0, n, n);
            QUEEN_IMG_H  = sprites.getSubimage(0 * n, n, n, n);
            KING_IMG     = sprites.getSubimage(1 * n, 0, n, n);
            KING_IMG_H   = sprites.getSubimage(1 * n, n, n, n);
            ROOK_IMG     = sprites.getSubimage(2 * n, 0, n, n);
            ROOK_IMG_H   = sprites.getSubimage(2 * n, n, n, n);
            KNIGHT_IMG   = sprites.getSubimage(3 * n, 0, n, n);
            KNIGHT_IMG_H = sprites.getSubimage(3 * n, n, n, n);
            PAWN_IMG     = sprites.getSubimage(4 * n, 0, n, n);
            PAWN_IMG_H   = sprites.getSubimage(4 * n, n, n, n);
        } catch (IOException x) {
            throw new UncheckedIOException(x);
        }
    }
}