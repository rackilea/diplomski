public class SimpleFileChooser {
      private final JFileChooser chooser;

      public SimpleFileChooser() {
           chooser = new JFileChooser();
           chooser.setDialogTitle("Select a File");
      }

      public File getFile() {
           int option = chooser.showOpenDialog(null);
           if (option == JFileChooser.APPROVE_OPTION) {
                return chooser.getSelectedFile();
           }
           return null;
      }
 }