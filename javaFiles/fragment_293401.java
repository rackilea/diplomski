import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sampling extends JFrame implements ActionListener {

    private JButton openStacker;

    Stacker st;

    public Sampling() {
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        openStacker = new JButton("Start Stacker!");

        add(openStacker);
        openStacker.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
        st = new Stacker();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Sampling();
            }
        });
    }
}

class Stacker extends JFrame implements KeyListener {

    int iteration = 1;
    double time = 200;
    int last = 0;
    int m = 10;
    int n = 20;
    JButton b[][];
    int length[] = {5, 5};
    int layer = 19;
    int deltax[] = {0, 0};
    boolean press = false;
    boolean forward = true;
    boolean start = true;

    Timer timer = new Timer((int)time, new ActionListener(){
        public void actionPerformed(ActionEvent event) {
            if (forward == true) {
                forward();
            } else {
                back();
            }
            if (deltax[1] == 10 - length[1]) {
                forward = false;
            } else if (deltax[1] == 0) {
                forward = true;
            }
            draw();
        }
    });

    public Stacker() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 580);
        this.setUndecorated(false);
        this.setLocationRelativeTo(null);

        b = new JButton[m][n];
        setLayout(new GridLayout(n, m));
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                b[x][y] = new JButton(" ");
                b[x][y].setBackground(Color.DARK_GRAY);
                add(b[x][y]);
                b[x][y].setEnabled(false);
            }//end inner for
        }

        this.setFocusable(true);
        this.pack();
        JPanel panel = (JPanel)getContentPane();
        panel.addKeyListener(this);
        this.setVisible(true);
        panel.requestFocusInWindow();

        go();
    }

    public void go() {

        int tmp = 0;
        Component temporaryLostComponent = null;
        timer.start();
        if (layer > 12) {
            time = 150 - (iteration * iteration * 2 - iteration);
        } else {
            time = time - 2.2;
        }
        iteration++;
        layer--;
        press = false;
        tmp = check();
        length[0] = length[1];
        length[1] = tmp;
        if (layer == -1) {
            JOptionPane.showMessageDialog(temporaryLostComponent, "Congratulations! You beat the game!");

            repeat();
        }
        if (length[1] <= 0) {
            JOptionPane.showMessageDialog(temporaryLostComponent, "Game over! You reached line " + (18 - layer) + "!");

            repeat();
        }
        last = deltax[1];
        start = false;
        //go();
    }

    public int check() {
        if (start == true) {
            return length[1];
        } else if (last < deltax[1]) {
            if (deltax[1] + length[1] - 1 <= last + length[0] - 1) {
                return length[1];
            } else {
                return length[1] - Math.abs((deltax[1] + length[1]) - (last + length[0]));
            }
        } else if (last > deltax[1]) {
            return length[1] - Math.abs(deltax[1] - last);
        } else {
            return length[1];
        }
    }

    public void forward() {
        deltax[0] = deltax[1];
        deltax[1]++;
    }

    public void back() {
        deltax[0] = deltax[1];
        deltax[1]--;
    }

    public void draw() {
        for (int x = 0; x < length[1]; x++) {
            b[x + deltax[0]][layer].setBackground(Color.DARK_GRAY);

        }
        for (int x = 0; x < length[1]; x++) {
            b[x + deltax[1]][layer].setBackground(Color.CYAN);
        }
    }

    public void repeat() {
        if (JOptionPane.showConfirmDialog(null, "PLAY AGAIN?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
            new Stacker();
        } else {
            System.exit(0);
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Pressed");
            press = true;
        }

    }

    public void keyReleased(KeyEvent arg0) {

    }

    public void keyTyped(KeyEvent arg0) {

    }

}