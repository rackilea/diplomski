import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author ggrec
 *
 */
public class Tester
{

    // ==================== 3. Static Methods ====================

    public static void main(final String[] args)
    {
        new Tester();
    }


    // ==================== 4. Constructors ====================

    private Tester()
    {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        createContents(shell);

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }


    // ==================== 5. Creators ====================

    private static void createContents(final Composite parent)
    {
        final Composite mainContainer = new Composite(parent, SWT.NULL);
        mainContainer.setLayout(new GridLayout(5, false));
        mainContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        createHeaderRow(mainContainer);

        createRow(mainContainer);
        createRow(mainContainer);
        createRow(mainContainer);
    }


    /**
     * @param parent Must have a grid layout with 5 columns!
     */
    private static void createHeaderRow(final Composite parent)
    {
        new Label(parent, SWT.NULL); // Filler label

        final Label nameLabel = new Label(parent, SWT.BORDER);
        nameLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        nameLabel.setText("Name");

        final Label comboLabel = new Label(parent, SWT.BORDER);
        comboLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        comboLabel.setText("Combo");

        final Label usernameLabel = new Label(parent, SWT.BORDER);
        usernameLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        usernameLabel.setText("Username");

        final Label passwordLabel = new Label(parent, SWT.BORDER);
        passwordLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        passwordLabel.setText("Password");
    }


    /**
     * @param parent Must have a grid layout with 5 columns!
     */
    private static void createRow(final Composite parent/*, final Entity model*/)
    {
        final Button checkbox = new Button(parent, SWT.CHECK);
        checkbox.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

        final Label nameLabel = new Label(parent, SWT.NULL);
        nameLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        nameLabel.setText("FirstName LastName");

        final Combo combo = new Combo(parent, SWT.NULL);
        combo.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

        final Text usernameWidget = new Text(parent, SWT.NULL);
        usernameWidget.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

        final Text passwordWidget = new Text(parent, SWT.NULL);
        passwordWidget.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
    }

}