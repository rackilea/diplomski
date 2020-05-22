import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Askhsh6 {

    int gr, st;
    Dimension dim;

    public Askhsh6() {
        final JFrame fr1 = new JFrame("a Title");
        fr1.setSize(800, 600);
        fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr1.setVisible(true);
        fr1.setResizable(false);

        final JButton b = new JButton("G");
        dim = new Dimension(70, 50);
        b.setSize(dim);
        b.setFocusable(false);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                b.validate();
                b.repaint();
                boolean pop = b.isFocusOwner();

                pop = b.isFocusOwner();
                System.out.println("" + pop);
            }
        });
        final JPanel[][] p;
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(8, 6));

        p = new JPanel[8][6];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                p[i][j] = new JPanel();
                p[i][j].setLayout(new BorderLayout());

                p[i][j].setBorder(BorderFactory.createLineBorder(Color.orange));
                p1.add(p[i][j]);

            }
        }
        p[0][0].add(b, BorderLayout.CENTER);
        gr = st = 0;

        fr1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("DOWN");
                    if (gr + 1 < 8) {
                        p[gr][st].remove(b);
                        gr = gr + 1;
                        p[gr][st].add(b, BorderLayout.CENTER);

                        fr1.repaint();
                    }
                }
                if (ke.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("UP");
                    if (gr - 1 >= 0) {
                        p[gr][st].remove(b);
                        gr = gr - 1;
                        p[gr][st].add(b, BorderLayout.CENTER);

                        fr1.repaint();
                    }
                }
                if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("LEFT");
                    if (st - 1 >= 0) {
                        p[gr][st].remove(b);
                        st = st - 1;
                        p[gr][st].add(b, BorderLayout.CENTER);

                        fr1.repaint();
                    }
                }
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("RIGHT");
                    if (st + 1 < 6) {
                        p[gr][st].remove(b);
                        st = st + 1;
                        p[gr][st].add(b, BorderLayout.CENTER);

                        fr1.repaint();
                    }
                }
            }
        });
        fr1.add(p1);
        fr1.validate();
    }
}