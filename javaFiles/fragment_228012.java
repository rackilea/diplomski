import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Sprites {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frm1 = new JFrame();
                Painel1 pn1 = new Painel1();
                frm1.getContentPane().add(pn1);

                frm1.pack();
                frm1.setVisible(true);
                frm1.setLocationRelativeTo(null);
                frm1.setResizable(false);
                frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}

class Painel1 extends JPanel {

    int[][] spriteSheetCoords = { { 8, 10, 119, 129 }, { 138, 10, 118, 130 }, { 267, 10, 118, 132 },
            { 402, 11, 113, 132 }, { 538, 12, 106, 134 }, { 671, 13, 103, 133 }, { 804, 12, 102, 132 },
            { 23, 161, 100, 134 }, { 157, 162, 96, 134 }, { 287, 159, 95, 135 }, { 418, 158, 95, 133 },
            { 545, 159, 99, 133 }, { 673, 159, 102, 134 }, { 798, 158, 108, 130 }, { 9, 309, 116, 126 },
            { 137, 309, 118, 127 }, { 274, 310, 110, 128 }, { 412, 311, 102, 129 }, { 541, 312, 103, 130 },
            { 671, 312, 104, 131 }, { 806, 312, 98, 132 }, { 29, 463, 94, 135 }, { 155, 462, 98, 135 },
            { 279, 461, 104, 135 }, { 409, 461, 106, 135 }, { 536, 461, 109, 135 }, { 662, 461, 112, 133 } };

    int i = 0;
    BufferedImage img;

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            i++;
            if (i == spriteSheetCoords.length) {
                i = 0;
            }
            revalidate();
            repaint();
        }
    };

    public Painel1() {
        Timer timer = new Timer(50, actionListener);
        timer.setInitialDelay(0);
        timer.start();
        setBackground(Color.yellow);
        try {
            img = ImageIO.read(new File("/home/jesus/Pictures/tokyo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Image subSprite;
        super.paintComponent(g);
        subSprite = img.getSubimage(spriteSheetCoords[i][0], spriteSheetCoords[i][1], spriteSheetCoords[i][2], spriteSheetCoords[i][3]);
        g.drawImage(subSprite, 140, 120, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}