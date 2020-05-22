import java.awt.event.ActionEvent;
import javax.swing.*;

public class FrameLaunch {
void inti(){
final JFrame f=new JFrame();
final JFrame f2=new JFrame();
final JTextArea ja=new JTextArea();

JButton b =new JButton("press for a new JFrame");
f2.add(b);
f2.pack();
f2.setVisible(true);
b.addActionListener(new java.awt.event.ActionListener()
 {
       public void actionPerformed(ActionEvent e) {
            f2.setVisible(false);
            f.setSize(200,200);
            ja.setText("THIS IS NOT FROZEN");
            f.add(ja);
            f.setVisible(true);
            f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        }
        });
}
public static void main(String[] args)
  {
FrameLaunch frame = new  FrameLaunch();
frame.inti();
  }
}