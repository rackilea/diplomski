import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Fenetre extends JComponent {

    private boolean color;

    /**
     * Constructeur de l'objet
     */
    public Fenetre() {
        color = true;
        setPreferredSize(new Dimension(1000, 300));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, 1000, 300);
        if (color) {
            g.setColor(Color.orange);
        } else {
            g.setColor(Color.blue);
        }
        g.fillRect(8, 25, 200, 100);
        g.setColor(Color.green);
        g.drawString("Text", 10, 10);
    }

    public void lol() {
        if (color) {
            color = false;
        } else {
            color = true;
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                initUI();
            }
        });
    }

    protected static void initUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Animation");
        frame.setSize(1000, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel container = new JPanel();
        final JTextField jtf = new JTextField();
        final Fenetre fenetre = new Fenetre();
        JLabel label = new JLabel("Commandes   ");
        JButton b = new JButton("OK");
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        jtf.setPreferredSize(new Dimension(800, 30));
        class BoutonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf.getText().equals("lol")) {
                    fenetre.lol();
                }
                System.out.println("Entry  : " + jtf.getText());
            }
        }
        b.addActionListener(new BoutonListener());

        top.add(fenetre);
        top.add(label);
        top.add(jtf);
        top.add(b);
        top.revalidate();
        frame.setContentPane(top);
        frame.setVisible(true);
    }
}