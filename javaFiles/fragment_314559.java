public class Test{
   public static void main(String... args){
      JFrame frame = new JFrame("Testing");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //this JPanel paints its own background
      JPanel myPanel = new PaintPane();

      frame.add(myPanel);
      myPanel.add(new JTextField("text field");
      myPanel.add(new JButton("button"));

      frame.setSize(500, 500);
      frame.setVisible(true);
   }
}