import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainWindow extends JFrame {

    private static final int WIDTH = 250, HEIGHT = 200;
    private Color[] colors;
    private int colorIndex = 0;
    private JLabel redLabel;

    public MainWindow() {

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setColors();
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        redLabel = new JLabel("A Test Label");
        redLabel.setBackground(colors[colorIndex]);
        redLabel.setOpaque(true);
        redLabel.setPreferredSize(new Dimension(100, 50));
        mainPanel.add(redLabel, BorderLayout.NORTH);

        JButton button = new JButton("Manual Color Change");
        button.addActionListener( e-> changeColor() );
        mainPanel.add(button, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void setColors() {

        colors = new Color[] {
                new Color(110, 110, 110),
                Color.CYAN,
                Color.RED,
                Color.YELLOW
                };
    }

    private void changeColor() {

        colorIndex = ((colorIndex+1) >= colors.length) ? 0 : colorIndex+1;
        redLabel.setBackground(colors[colorIndex]);
    }

    public static void main(String[] args) throws InterruptedException {

        MainWindow win = new MainWindow();
        //auto change color every 2 sec
        new Timer(2000, e-> win.changeColor()).start();
    }
}