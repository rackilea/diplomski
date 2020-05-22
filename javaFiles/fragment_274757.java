import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class StyledTextTest {

    private static Display display;

    public static void main(String[] args) 
    {
        display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(2,true));
        shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        createStyledText(shell);
        createStyledText(shell);

        createText(shell);
        createText(shell);

        createCombo(shell);
        createCombo(shell);

        createCustomCombo(shell);
        createCustomCombo(shell);

        createBrowser(shell);
        createBrowser(shell);

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    private static void createCustomCombo(Composite parent) 
    {
        new Label(parent, SWT.NONE).setText("Custom Combo");
        CCombo c = new CCombo(parent, SWT.DROP_DOWN);
        c.setItems(new String[] {"test best", "best rest", "rest test"});
        c.select(0);        
        c.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    }

    private static void createCombo(Composite parent) 
    {
        new Label(parent, SWT.NONE).setText("Combo");
        Combo c = new Combo(parent, SWT.DROP_DOWN);
        c.setItems(new String[] {"test best", "best rest", "rest test"});
        c.select(0);        
        c.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    }

    static void createBrowser(Composite parent)
    {
        new Label(parent, SWT.NONE).setText("Browser");
        Browser browser = new Browser(parent, SWT.NONE);
        browser.setText("<div>This is a test !!</div>");
        browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    }

    static void createText(Composite parent) {
        new Label(parent, SWT.NONE).setText("Text");
        final Text text = new Text(parent, SWT.BORDER);
        text.setText("0123456789 ABCDEFGHIJKLM NOPQRSTUVWXYZ");

    }

    static void createStyledText(Composite parent)
    {
        new Label(parent, SWT.NONE).setText("Styled Text");

        StyledText text = new StyledText (parent, SWT.BORDER|SWT.SINGLE);
        text.setText("0123456789 ABCDEFGHIJKLM NOPQRSTUVWXYZ");
        // make 0123456789 appear bold
        StyleRange style1 = new StyleRange();
        style1.start = 0;
        style1.length = 10;
        style1.fontStyle = SWT.BOLD;
        text.setStyleRange(style1);
        // make ABCDEFGHIJKLM have a red font
        StyleRange style2 = new StyleRange();
        style2.start = 11;
        style2.length = 13;
        style2.foreground = display.getSystemColor(SWT.COLOR_RED);
        text.setStyleRange(style2);
        // make NOPQRSTUVWXYZ have a blue background
        StyleRange style3 = new StyleRange();
        style3.start = 25;
        style3.length = 13;
        style3.fontStyle = SWT.BOLD | SWT.ITALIC;
        text.setStyleRange(style3);

    }
}