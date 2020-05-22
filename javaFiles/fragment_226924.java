import java.awt.EventQueue;

import javax.swing.*;

public class MenuExample {
  private JFrame myJFrameObject;

  public MenuExample() {
    myJFrameObject = new JFrame();

    JButton b1 = new JButton("Option 1");
    JButton b2 = new JButton("Option 2");
    JPanel p = new JPanel();
    p.add(b1);
    p.add(b2);
    myJFrameObject.setContentPane(p);

    JMenuBar mb = new JMenuBar();
    JMenu pm = new JMenu("File");
    mb.add(pm);
    myJFrameObject.setJMenuBar(mb);

    myJFrameObject.pack();
  }

  public void setVisible(boolean visible) {
    myJFrameObject.setVisible(visible);
  }

  public static void main(String... args) {
    final MenuExample example = new MenuExample();

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        example.setVisible(true);
      }
    });
  }
}