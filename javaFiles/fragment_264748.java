import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

    public static void main(String[] args) {

        int width = 800;
        int height = 600;
        String title = "Test";

        JFrame display = new JFrame();
        display.setTitle(title);
        display.setSize(width, height);
        display.setVisible(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display.setContentPane(new MainPanel());
    }

    public MainPanel() {
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawLine(0, 100, 800, 300);
    }
}