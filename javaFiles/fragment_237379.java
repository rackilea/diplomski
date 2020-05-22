import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.event.SwingPropertyChangeSupport;

public class CaptureHotKey implements Runnable {
   public static final String HOT_KEY = "hot key";
   private String hotKey;
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
         this);
   private Scanner scanner;
   private CaptureHotKeyFromAutoIt capture;

   public CaptureHotKey(final String hotKey) throws IOException {
      this.hotKey = hotKey;     
      capture = new CaptureHotKeyFromAutoIt(hotKey);
      scanner = new Scanner(capture.getReadable());
   }

   public void startCapturing() {
      new Thread(this).start();
   }

   public void exit() {
      if (capture != null) {
         capture.exit();  
      }
      if (scanner != null) {
         scanner.close();
      }
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public String getHotKey() {
      return hotKey;
   }

   @Override
   public void run() {
      while (scanner != null && scanner.hasNextLine()) {
         scanner.nextLine();
         pcSupport.firePropertyChange(HOT_KEY, true, false);
      }
   }

   private static class CaptureHotKeyFromAutoIt {
      public static final String AUTO_IT_APP_PATH = "CaptureHotKey.exe";

      private Process process = null;
      private ProcessBuilder pb;

      public CaptureHotKeyFromAutoIt(String hotKey) throws IOException {
         List<String> cmdList = new ArrayList<>();
         cmdList.add(AUTO_IT_APP_PATH);
         cmdList.add(hotKey);
         pb = new ProcessBuilder(cmdList);
         pb.redirectErrorStream(true);
         process = pb.start();
      }

      public void exit() {
         if (process != null) {
            process.destroy();
         }
      }

      public Readable getReadable() {
         if (process != null) {
            return new InputStreamReader(process.getInputStream());
         }
         return null;
      }
   }
}