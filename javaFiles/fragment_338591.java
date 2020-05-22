class Frame extends JFrame {

   Frame() {
      setBounds(100, 200, 120, 120);
      setTitle("null");
      setVisible(true);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   }
}

public class test001 {

   public static void main(String Args[]) {
      Frame f = new Frame();
      System.out.print("Visible = True");

      f.setVisible(false);
      System.out.print("Visible = false");
   }
}