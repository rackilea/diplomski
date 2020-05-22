public class MainClass extends JFrame {

   @Override
   public void actionPerformed(ActionEvent e) {
      Object source = e.getSource();
      System.out.println( "Action triggered by: " + source );
   }

   private static void createAndShowGUI() {
      ...
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      MenuBar menuBar = new MenuBar();
      JMenuBar mb = menuBar.createMenu( frame );
      frame.setJMenuBar( mb );
      ...
   }
}