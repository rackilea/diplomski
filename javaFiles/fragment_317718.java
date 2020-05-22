public class FooGUI {

   // .....

   public void myRun() {
      String text1 = someTextField.getText();
      String text2 = otherTextField.getText();
      final BulkProcessor bulkProcessor = new BulkProcessor(text1, text2);
      bulkProcessor.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (pcEvt.getPropertyName().equals("progress")) {
               int progress = bulkProcessor.getProgress();
               someProgressBar.setValue(progress);
            }
         }
      });
   }
}

class BulkProcessor extends SwingWorker<Void, Void> {
   private Random random = new Random(); // just for SSCCE sake
   private String text1;
   private String text2;

   public BulkProcessor(String text1, String text2) {
      this.text1 = text1;
      this.text2 = text2;
      // not sure what you do with these texts....
   }

   @Override
   protected Void doInBackground() throws Exception {
      int progress = 0;
      while (progress <= 100) {
         progress = random.nextInt(5); // just as a for instance
                                    // your code will do something else of course
         setProgress(progress);
         Thread.sleep(300);
      }
      return null;
   }

}