import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Test {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);

        final Text text = new Text(shell, SWT.BORDER);
        text.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent e) {
                // allows cut (CTRL + x)
                if (e.text.isEmpty()) {
                    e.doit = true;
                } else if (e.keyCode == SWT.ARROW_LEFT ||
                            e.keyCode == SWT.ARROW_RIGHT ||
                            e.keyCode == SWT.BS ||
                            e.keyCode == SWT.DEL ||
                            e.keyCode == SWT.CTRL ||
                            e.keyCode == SWT.SHIFT) {
                    e.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < e.text.length(); i++) {
                        char c = e.text.charAt(i);
                        allow = Character.isDigit(c) || Character.isWhitespace(c);
                        if ( ! allow ) {
                            break;
                        }
                    }
                    e.doit = allow;
                }

            }
        });
        text.setSize(200, 20);
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}