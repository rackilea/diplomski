import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class CreateWebsiteThumbnail {

   private static final int WIDTH  = 800;
   private static final int HEIGHT = 600;


   public static void main( String[] args ) throws IOException {
      final Display display = new Display();
      final Shell shell = new Shell();
      shell.setLayout(new FillLayout());
      final Browser browser = new Browser(shell, SWT.EMBEDDED);
      browser.addProgressListener(new ProgressListener() {

         @Override
         public void changed( ProgressEvent event ) {}

         @Override
         public void completed( ProgressEvent event ) {
            shell.forceActive();
            display.asyncExec(new Runnable() {

               @Override
               public void run() {
                  grab(display, shell, browser);
               }
            });

         }
      });
      browser.setUrl("http://www.google.com");

      shell.setSize(WIDTH, HEIGHT);
      shell.open();

      while ( !shell.isDisposed() ) {
         if ( !display.readAndDispatch() ) display.sleep();
      }
      display.dispose();
   }

   private static void grab( final Display display, final Shell shell, final Browser browser ) {
      final Image image = new Image(display, browser.getBounds());
      GC gc = new GC(browser);
      gc.copyArea(image, 0, 0);
      gc.dispose();

      ImageLoader loader = new ImageLoader();
      loader.data = new ImageData[] { image.getImageData() };
      loader.save("foo.png", SWT.IMAGE_PNG);
      image.dispose();

      shell.dispose();
   }

}