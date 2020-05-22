import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PipesGame {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                final CardLayout cl = new CardLayout();
                final JPanel gui = new JPanel(cl);
                // remove if no border is needed
                gui.setBorder(new EmptyBorder(10,10,10,10));

                JPanel menu = new JPanel(new GridBagLayout());
                JButton playGame = new JButton("Play!");
                ActionListener playGameListener = new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cl.show(gui, "game");
                    }
                };
                playGame.addActionListener(playGameListener);
                Insets margin = new Insets(20, 50, 20, 50);
                playGame.setMargin(margin);
                menu.add(playGame);
                gui.add(menu);
                cl.addLayoutComponent(menu, "menu");

                JPanel pipes = new Pipes();
                gui.add(pipes);
                cl.addLayoutComponent(pipes, "game");

                JFrame f = new JFrame("Pipes Game");
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See https://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}

class Pipes extends JPanel {

    Pipes() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Pipes game appears here..", 170, 80);
    }

    @Override 
    public Dimension getPreferredSize() {
        // adjust to need
        return new Dimension(500,150);
    }
}