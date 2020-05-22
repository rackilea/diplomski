import javax.swing.JFrame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BrowserSwingPanel {

   public static void main(String args[]) {

      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      Canvas canvas = new Canvas();
      f.setSize(500, 400);
      f.add(canvas);
      f.setVisible(true);
      Display display = new Display();
      Shell shell = SWT_AWT.new_Shell(display, canvas);
      shell.setSize(500, 400);
      Browser browser = new Browser(shell, SWT.NONE);
      browser.setSize(500, 400);
      browser.setUrl("http://www.google.com");
      shell.open();
      while (!shell.isDisposed() && f.isVisible()) {
         if (!display.readAndDispatch())
            display.sleep();
      }
      display.dispose();
      f.dispose();
   }
}