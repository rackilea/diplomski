import java.awt.*;
import javax.swing.*;

public class BoxAlignmentTest2 extends JFrame {
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      BoxAlignmentTest2 test = new BoxAlignmentTest2();
      test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      test.setSize(500, 200);
      test.setVisible(true);
    });
  }

  public BoxAlignmentTest2() throws HeadlessException {
    JLabel label = new JLabel("This label isn't fully left-aligned.");
    label.setOpaque(true);
    label.setBackground(Color.orange);
    label.setAlignmentX(Component.LEFT_ALIGNMENT); // Set left alignment

    JScrollPane scroll = new JScrollPane(new JTextArea("This is a text area."));
    scroll.setAlignmentX(Component.LEFT_ALIGNMENT); // <- add

    Box box = Box.createVerticalBox();
    box.add(label);
    box.add(scroll);

    add(box); // = getContentPane().add(box, BorderLayout.CENTER);
  }
}