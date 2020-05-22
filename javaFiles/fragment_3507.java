import javax.swing.*;

public class BoxLayoutFoo extends JFrame {
   public BoxLayoutFoo() {

      // swap the comments below
      setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS)); // comment out this line
      //setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS)); // uncomment this line

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }

   public static void main(String[] args) {
      new BoxLayoutFoo();
   }
}