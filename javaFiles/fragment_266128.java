import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Test {

  public static void main(String[] args) {
    new Test();
  }

  public Test() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame();
        frame.add(new TestPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }

  public class TestPane extends JPanel {

    public TestPane() {
      setLayout(new GridBagLayout());
      add(new JLabel("I'm in the middle"));
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(800, 600);
    }

  }

}