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
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();

        // Gameloop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                // updates++;
                delta--;
            }
            System.out.println("repaint");
            main.repaint();
            frames++;
        }
    }
}