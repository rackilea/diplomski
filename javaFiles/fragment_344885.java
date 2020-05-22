package testplugin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SWTHelloWorld {

public static void main (String [] args) {
    Display display = new Display ();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout());
    Label labelWidget = new Label(shell, SWT.NONE);
    labelWidget.setText("Hello");

    Text textWidget = new Text(shell, SWT.NONE);
    textWidget.setText("Hello");

    //Set background color same as its container
    textWidget.setBackground(shell.getBackground());
    //Make editable false
    textWidget.setEditable(false);

    StyledText styledTextWidget = new StyledText(shell, SWT.NONE);
    styledTextWidget.setText("Hello");  
    styledTextWidget.setBackground(shell.getBackground());
    styledTextWidget.setEditable(false);
    //Set caret null this will hide caret
    styledTextWidget.setCaret(null);

    shell.pack();
    shell.open ();
    shell.setSize(200, 300);
    while (!shell.isDisposed ()) {
        if (!display.readAndDispatch ()) display.sleep ();
    }
    display.dispose ();
}
}