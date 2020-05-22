package sample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SampleApp 
{
    public SampleApp(Shell shell)
    {
        AppPersonViewer personViewer = new AppPersonViewer(shell, SWT.BORDER|SWT.V_SCROLL|SWT.FULL_SELECTION);
        DataModel model = new DataModel(20);
        personViewer.setInput(model);
    }

    public static void main(String[] args) {
        Display display = new Display ();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        new SampleApp(shell);
        shell.open ();

        while (!shell.isDisposed ()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }

        display.dispose ();
    }
}