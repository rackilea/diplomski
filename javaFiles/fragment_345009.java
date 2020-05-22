import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

  private JButton button;

  public Frame() {
    initComponents();
  }

  private void initComponents() {
    button = new JButton("Add New Recipe Panel");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Frame.this.getContentPane().add(new NewRecipe(), BorderLayout.CENTER);
        Frame.this.getContentPane().revalidate();
      }
    });
    this.getContentPane().add(button, BorderLayout.NORTH);
  }

  public static void main(String[] args) {
    Frame frame = new Frame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(200, 100, 400, 300);
    frame.setVisible(true);
  }

  class NewRecipe extends JPanel {

    NewRecipe() {
      this.add(new JLabel("New Recipe"));
    }
  }
}