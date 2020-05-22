package stackoverflowtests;

import javax.swing.JFrame;

public class Main extends JFrame {

    public Main() {
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Skeleton skeli = new Skeleton();
        skeli.setLocation(0, 0);
        skeli.setSize(1000, 500);
        add(skeli);
        new Thread(skeli).start();
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();

    }
}