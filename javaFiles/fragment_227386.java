import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppWithSound2 extends JFrame implements ActionListener {
  JButton b1;
  JButton b2;

  private static final long serialVersionUID = 1L;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        AppWithSound2 app = new AppWithSound2();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.startApp();
      }
    });
  }

  public AppWithSound2() {
    initGUI();
  }

  private void startApp() {
    setVisible(true);
  }

  private void initGUI() {
    setLayout(new FlowLayout());
    setSize(300, 200);
    b1 = new JButton("Sound with no thread");
    b2 = new JButton("Sound with thread");
    b1.addActionListener(this);
    b2.addActionListener(this);
    add(b1);
    add(b2);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
      LaserSound.laser();
    }
    if (e.getSource() == b2) {
      new LaserSound().start();
    }
  }
}

class LaserSound extends Thread {

  public void run() {
    LaserSound.laser();
  }

  public static void laser() {
    int repeat = 10;
    try {
      AudioFormat af = new AudioFormat(8000f, // sampleRate
          8, // sampleSizeInBits
          1, // channels
          true, // signed
          false); // bigEndian
      SourceDataLine sdl;
      sdl = AudioSystem.getSourceDataLine(af);
      sdl.open(af);
      sdl.start();

      byte[] buf = new byte[1];
      int step;

      for (int j = 0; j < repeat; j++) {
        step = 10;
        for (int i = 0; i < 2000; i++) {
          buf[0] = ((i % step > 0) ? 32 : (byte) 0);

          if (i % 250 == 0)
            step += 2;
          sdl.write(buf, 0, 1);
        }
        Thread.sleep(200);
      }
      sdl.drain();
      sdl.stop();
      sdl.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}