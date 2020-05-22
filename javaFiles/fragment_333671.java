import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class Snippet22 {

   public static void main( String[] args ) {
      Display display = new Display();
      Shell shell = new Shell(display);
      Text text = new Text(shell, 0);
      text.setText("ASDF");
      text.setSize(64, 32);
      shell.pack();
      shell.open();
      while ( !shell.isDisposed() ) {
         if ( !display.readAndDispatch() ) display.sleep();
      }
      display.dispose();
   }
}