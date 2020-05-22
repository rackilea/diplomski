import java.io.File;
import javax.swing.JFileChooser;

public class ShowDirectoriesOnly {
   public static void main(String[] args) {
      JFileChooser fileChooser = new JFileChooser( "." );
      fileChooser.setControlButtonsAreShown( false );
      fileChooser.setFileFilter( new FolderFilter() );
      fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      fileChooser.showOpenDialog(null);
   }

   private static class FolderFilter extends javax.swing.filechooser.FileFilter {
      @Override
      public boolean accept( File file ) {
        return file.isDirectory();
      }

      @Override
      public String getDescription() {
        return "We only take directories";
      }
    }
}