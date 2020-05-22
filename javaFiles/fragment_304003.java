import javax.swing.*;
import java.awt.*;

class AnimationFrame extends JPanel {

    int ovalX = 50;
    long animDuration = 5000;
    long currentTime = System.nanoTime() / 1000000;
    long startTime = currentTime;
    long elapsedTime = currentTime - startTime;

    public AnimationFrame() {
        setPreferredSize(new Dimension(500, 500));
        //i removed the call to runAnimation from here

    }

    public void runAnimation() {
        while (elapsedTime < animDuration) {
            currentTime = System.nanoTime() / 1000000;
            elapsedTime = currentTime - startTime;
            System.out.println(elapsedTime);
            ovalX = ovalX + 1;
            try {
                Thread.sleep(30);
            }
            catch (Exception e) {
            }
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        Rectangle clip = g.getClipBounds();
        g.setColor(Color.BLACK);
        g.fillRect(clip.x, clip.y, clip.width, clip.height);
        g.setColor(Color.BLUE);
        g.fillOval(ovalX, 250, 70, 70);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }

    public static void createAndShowGUI() {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AnimationFrame animationPanel = new AnimationFrame();
        mainFrame.add(animationPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
        //I made the call to runAnimation here now
        //after the containing frame is visible.
        animationPanel.runAnimation();
    }
}