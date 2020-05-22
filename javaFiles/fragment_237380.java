import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Scanner;

public class CaptureHotKeyTest {
   public static final String CTRL_R = "^r"; // "{SPACE}" works for spacebar
   private static final String EXIT = "exit";
   private CaptureHotKey capture;

   public CaptureHotKeyTest() {
      try {
         capture = new CaptureHotKey(CTRL_R);
         capture.addPropertyChangeListener(new HotKeyPropertyChngListener());
         capture.startCapturing();

         Scanner scan = new Scanner(System.in);
         System.out.println("Press control-r to get mouse position.");
         System.out.println("Type \"exit\" to exit program");
         while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equalsIgnoreCase(EXIT)) {
               scan.close();
               capture.exit();
               break;
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }      
   }

   private class HotKeyPropertyChngListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (evt.getPropertyName().equals(CaptureHotKey.HOT_KEY)) {
            System.out.println("hot key pressed");

            PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            System.out.println("Mouse: " + pointerInfo.getLocation());
         }
      }
   }

   public static void main(String[] args) {
      new CaptureHotKeyTest();
   }

}