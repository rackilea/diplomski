import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerTest extends JFrame {
  public static void main(String[] args) { new TimerTest().setVisible(true); }

  private static final int DEFAULT_SPEED = 500;
  private int speedCounter = 1;
  private int currentSpeed = DEFAULT_SPEED / speedCounter;
  private int squareX = 150;

  public TimerTest() {
    super("Test");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(300, 200));
    setLayout(new BorderLayout());
    setLocationRelativeTo(null);

    JPanel displayPanel = new JPanel(null) {
      @Override
      public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(squareX, getHeight() / 2, 25, 25);
      }
    };

    final Timer timer = new Timer(currentSpeed, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squareX = (squareX + 15) % getWidth();
        repaint();
      }
    });
    timer.setRepeats(true);

    JButton fastForwardButton = new JButton(new AbstractAction(">>") {
      @Override
      public void actionPerformed(ActionEvent e) {
        speedCounter++;
        currentSpeed = DEFAULT_SPEED / speedCounter;

        timer.stop();
        timer.setDelay(currentSpeed);
        timer.start();
      }
    });
    add(displayPanel, BorderLayout.CENTER);
    add(fastForwardButton, BorderLayout.SOUTH);
    timer.start();
  }
}