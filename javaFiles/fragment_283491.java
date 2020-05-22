public class Test {
   private static void initAndShowGUI() {
       // This method is invoked on Swing thread
       JFrame frame = new JFrame("FX");
       final JFXPanel fxPanel = new JFXPanel();
       frame.add(fxPanel);
       frame.setVisible(true);

       Platform.runLater(new Runnable() {
           @Override
           public void run() {
               initFX(fxPanel);
           }
       });
   }

   private static void initFX(JFXPanel fxPanel) {
       // This method is invoked on JavaFX thread
       Scene scene = createScene();
       fxPanel.setScene(scene);
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               initAndShowGUI();
           }
       });
   }
}