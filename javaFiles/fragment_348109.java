import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame("random title");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }

}

class MyPanel extends JPanel {
    private static final long   serialVersionUID    = 1L;
    public boolean              paintButton         = true;
    public int                  x;
    public int                  y;
    public int                  remoteControllerX   = 473;
    public int                  remoteControllerY   = 340;
    public int                  buttonX             = 166;
    public int                  buttonY             = 208;
    Image                       img;
    Image                       remoteController;
    ImageIcon                   button              = new ImageIcon(
                                                            "graphics/button.gif");
    Component                   buttonTrigger       = this;

    public MyPanel() {
        try {
            img = ImageIO.read(new File("graphics/close_0.jpg"));
            remoteController = ImageIO.read(new File("graphics/pilot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setBorder(BorderFactory.createLineBorder(Color.black));

        new Timer(3000, paintTimer).start();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                // Here goes action on background, which is unrelated to this
                // example.
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1048, 484);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img, 0, 0, null);
        g.drawImage(remoteController, remoteControllerX, remoteControllerY,
                null);
        Toolkit.getDefaultToolkit().sync();
        if (paintButton) {
            button.paintIcon(buttonTrigger, g, buttonX, buttonY);
        }
    }

    Action  paintTimer  = new AbstractAction() {
        private static final long   serialVersionUID    = -2121714427110679013L;

        @Override
        public void actionPerformed(ActionEvent e) {
            paintButton = false;
            repaint();
        }
    };

}