import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Test {

    private static Text text;

    public static void main (String [] args) 
    {
        Display display = new Display ();
        final Shell shell = new Shell (display);
        shell.setLayout(new GridLayout());
        shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        shell.setSize(200, 100);
        shell.setText("Parent Shell");

        Label label = new Label(shell, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        label.setText("The text from child shell ...");

        text = new Text(shell, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        Button openChild = new Button(shell, SWT.PUSH);
        openChild.setText("Open Child ...");
        openChild.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                openChild(shell);
            }
        });

        shell.open ();

        while (!shell.isDisposed ()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }

    private static void openChild(Shell parent)
    {
        final Shell dialog = new Shell (parent, SWT.DIALOG_TRIM);
        dialog.setLayout(new GridLayout());
        dialog.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        dialog.setSize(200, 100);
        dialog.setText("Child Shell");

        Label childLabel = new Label(dialog, SWT.NONE);
        childLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        childLabel.setText("Type something here ...");

        final Text childText = new Text(dialog, SWT.BORDER);
        childText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        Button okButton = new Button (dialog, SWT.PUSH);
        okButton.setText ("&OK");
        okButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                dialog.close();
            }
        });


        dialog.addShellListener(new ShellListener() {
            public void shellIconified(ShellEvent e) {
            }
            public void shellDeiconified(ShellEvent e) {
            }
            public void shellDeactivated(ShellEvent e) {
            }
            public void shellClosed(ShellEvent e) {
                if(text != null && !text.isDisposed())
                    text.setText(childText.getText());
            }
            public void shellActivated(ShellEvent e) {
            }
        });


        dialog.setDefaultButton (okButton);
        dialog.open ();
    }
}