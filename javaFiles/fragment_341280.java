public class Myplay{


public static void main(String[] args) {
    ...... YOUR CODE TO FOR UI.......
JButton btn1 = new JButton("Play");
    btn1.addActionListener(new ButtonListener());
    add(btn1); // ADD BUTTON TO JPanel
JButton btn2 = new JButton("Stop");
    btn2.addActionListener(new ButtonListener());
    add(btn2);  // ADD BUTTON TO JPanel
  }
}

}

class ButtonListener implements ActionListener {

ButtonListener() {
InputStream in = new FileInputStream(new File("C:\\Users\\A\\Downloads\\Music\\I.wav"));
AudioStream ikon = new AudioStream(in);
}

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Play")) {
      AudioPlayer.player.start(ikon);
    }
if (e.getActionCommand().equals("Stop")) {
      AudioPlayer.player.stop(ikon);
    }
  }
}