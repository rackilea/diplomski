import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Snippet19 {
    private static String temp = "";

    public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout());
    final Text text = new Text(shell, SWT.BORDER);
    text.setLayoutData(new GridData());
    text.addFocusListener(new FocusListener() {

        @Override
        public void focusLost(FocusEvent e) {
            if (temp.equals(text.getText())) {
                System.out.println("Text not modified");
            } else {
                System.out.println("Text conent modified");
            }

        }

        @Override
        public void focusGained(FocusEvent e) {
            temp = text.getText();

        }
    });
    final Text text1 = new Text(shell, SWT.BORDER);
    text1.setText("chandrayya");
    text1.setLayoutData(new GridData());
    final Text text2 = new Text(shell, SWT.BORDER);
    text2.setText("chandrayya");
    text2.setLayoutData(new GridData());
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
    }
}