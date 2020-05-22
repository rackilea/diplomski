package mcve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.net.*;
import java.io.*;

public class MouseoverPanels {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseoverPanels::new);
    }

    MouseoverPanels() {
        JFrame frame = new JFrame("Mouseover Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.WHITE);

        buttons.add(new MouseoverPanel("Queen",  QUEEN_IMG));
        buttons.add(new MouseoverPanel("King",   KING_IMG));
        buttons.add(new MouseoverPanel("Rook",   ROOK_IMG));
        buttons.add(new MouseoverPanel("Knight", KNIGHT_IMG));
        buttons.add(new MouseoverPanel("Pawn",   PAWN_IMG));

        frame.setContentPane(buttons);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class MouseoverPanel extends JPanel {
        static final String BUTTON_KEY = "BUTTON";
        static final String ICON_KEY   = "ICON";

        final CardLayout layout = new CardLayout();

        MouseoverPanel(String text, Image img) {
            setLayout(layout);
            setOpaque(false);

            JButton button = new JButton(text);
            button.setBorderPainted(false);
            button.setOpaque(false);

            JLabel icon = new JLabel(new ImageIcon(img));
            icon.setOpaque(false);

            add(button, BUTTON_KEY);
            add(icon,   ICON_KEY);

            layout.show(this, ICON_KEY);

            MouseoverListener ml = new MouseoverListener();

            addMouseListener(ml);
            button.addMouseListener(ml);
            icon.addMouseListener(ml);
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
                Point     loc  = SwingUtilities.convertPoint(comp, e.getPoint(), MouseoverPanel.this);
                String    key  = contains(loc) ? BUTTON_KEY : ICON_KEY;
                layout.show(MouseoverPanel.this, key);
            }
        }
    }

    static final Image QUEEN_IMG,
                       KING_IMG,
                       ROOK_IMG,
                       KNIGHT_IMG,
                       PAWN_IMG;
    static {
        try {
            // source for sprite sheet: https://stackoverflow.com/a/19209651/2891664
            BufferedImage sprites = ImageIO.read(new URL("https://i.stack.imgur.com/memI0.png"));
            int n = 64;
            QUEEN_IMG  = sprites.getSubimage(0 * n, 0, n, n);
            KING_IMG   = sprites.getSubimage(1 * n, 0, n, n);
            ROOK_IMG   = sprites.getSubimage(2 * n, 0, n, n);
            KNIGHT_IMG = sprites.getSubimage(3 * n, 0, n, n);
            PAWN_IMG   = sprites.getSubimage(4 * n, 0, n, n);
        } catch (IOException x) {
            throw new UncheckedIOException(x);
        }
    }
}