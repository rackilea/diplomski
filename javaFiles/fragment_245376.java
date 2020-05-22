public class MyWindow extends JFrame{

   public MyWindow(){
      super.setVisible(true);
      super.setSize(500,500);
      MyPanel panel = new MyPanel();
      super.setContentPane(panel);

   }
}