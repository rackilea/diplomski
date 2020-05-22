import org.eclipse.swt.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


public class ScroledCompositeExport {
    public static void main (String [] args) {
        final Display display = new Display ();
     Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        shell.setSize(200, 200);
        shell.setLocation(20, 20);

        final ScrolledComposite sc = new ScrolledComposite(shell, SWT.BORDER  | SWT.V_SCROLL | SWT.H_SCROLL);
        sc.setLayout(new GridLayout(1,true));

        final Composite innerComposite = new Composite(sc, SWT.NONE);
        innerComposite.setSize(400, 400);
        innerComposite.setLayout(new GridLayout(1, true));
        innerComposite.setBackground(new Color(display, 255, 0, 0));

        for(int i = 0; i < 10; i++)
        {
                Button b = new Button(innerComposite, SWT.PUSH);
                b.setText("Text");
                b.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent e) 
                    {
                        Image image = new Image(display, innerComposite.getBounds().width, innerComposite.getBounds().height);
                        ImageLoader loader = new ImageLoader();

                        GC gc = new GC(image);
                        innerComposite.print(gc);

                        gc.dispose();

                        loader.data = new ImageData[]{image.getImageData()};
                        loader.save("c:/temp/out.png", SWT.IMAGE_PNG);
                    }
                });
        }

        sc.setMinSize(innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        sc.setContent(innerComposite);
        sc.setExpandHorizontal(true);
        sc.setExpandVertical(true);

        shell.open();
        shell.open ();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }
}