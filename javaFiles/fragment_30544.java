import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Snippet99 {

  public static void main(String[] args) 
  {
    final private Display display = new Display();
    final private Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    final Composite container = new Composite(shell, SWT.NULL);
        container.setLayout(new FillLayout());

    final private Button btn = 
new Button(container, SWT.PUSH).setText("Button 1");
    final private PopupComposite pc1 = 
new  PopupComposite(Display.getDefault().getActiveShell(), SWT.NULL);
    final private Button btn2 = 
new Button(pc1, SWT.PUSH).setText("Button 2");
    final private PopupComposite pc2 = 

new PopupComposite(pc1.getShell(),SWT.NULL);

    private Text text = new Text(pc2, SWT.BORDER);
    /*
    only use final if you're setting the value immediately and will never change it again,
    make sure you set the accessibility of your items (protected/private/public)
    */

    Listener listener = new Listener() {
      public void handleEvent(Event event) {
        pc1.show(btn.getLocation());
      }
    };

    btn.addListener(SWT.Selection, listener);

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }
}