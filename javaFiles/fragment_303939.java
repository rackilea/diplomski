import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DummyDialog extends Dialog {

    private Composite composite;

    public DummyDialog(Shell parentShell)
    {
        super(parentShell);
        setShellStyle(parentShell.getStyle() | SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
        setBlockOnOpen(true);
    }

    protected Control createDialogArea(Composite parent) {
        this.composite = (Composite) super.createDialogArea(parent);

        GridLayout layout = new GridLayout(1, false);
        layout.marginHeight = 5;
        layout.marginWidth = 10;

        composite.setLayout(layout);

        createContent();

        return composite;
    }

    private void createContent()
    {
        createTopContent();

        createMiddleContent();

        createBottomContent();
    }

    private void createTopContent()
    {
        Composite top = new Composite(composite, SWT.NONE);

        top.setLayout(new GridLayout(2, false));
        top.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Label firstLabel = new Label(top, SWT.NONE);
        firstLabel.setText("X-Ref Library");
        Text firstText = new Text(top, SWT.BORDER);
        firstText.setText("MANISH2XA");
        firstText.setEditable(false);
        firstText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));

        Label secondLabel = new Label(top, SWT.NONE);
        secondLabel.setText("Text");
        Text secondText = new Text(top, SWT.BORDER);
        secondText.setText("Test Lib for Manish");
        secondText.setEditable(false);
        secondText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
    }

    private void createMiddleContent()
    {
        Composite middle = new Composite(composite, SWT.NONE);
        middle.setLayout(new GridLayout(3, false));
        middle.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        Group leftGroup = new Group(middle, SWT.NONE);
        leftGroup.setText("Object Library(s)");
        leftGroup.setLayout(new GridLayout(1, false));
        leftGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        List leftList = new List(leftGroup, SWT.BORDER);
        leftList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        leftList.add("DUMMY");

        Composite buttons = new Composite(middle, SWT.NONE);
        buttons.setLayout(new GridLayout(1, false));

        Button moveUp = new Button(buttons, SWT.PUSH);
        moveUp.setText("Move up");
        moveUp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
        Button moveDown = new Button(buttons, SWT.PUSH);
        moveDown.setText("Move down");
        moveDown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
        Button modify = new Button(buttons, SWT.PUSH);
        modify.setText("Modify");
        modify.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
        Button remove = new Button(buttons, SWT.PUSH);
        remove.setText("Remove");
        remove.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));

        Group rightGroup = new Group(middle, SWT.NONE);
        rightGroup.setText("Source Library(s)");
        rightGroup.setLayout(new GridLayout(1, false));
        rightGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        List rightList = new List(rightGroup, SWT.BORDER);
        rightList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        rightList.add("DUMMY");
    }

    private void createBottomContent()
    {
        Composite bottom = new Composite(composite, SWT.NONE);
        bottom.setLayout(new GridLayout(3, false));
        bottom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Label leftLabel = new Label(bottom, SWT.NONE);
        leftLabel.setText("Library");

        Label rightLabel = new Label(bottom, SWT.NONE);
        rightLabel.setText("Type");

        new Label(bottom, SWT.NONE);

        Text leftText = new Text(bottom, SWT.BORDER);
        leftText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));

        Combo combo = new Combo(bottom, SWT.NONE);
        combo.add("Object Library");
        combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));

        Button add = new Button(bottom, SWT.PUSH);
        add.setText("Add");
        add.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
    }

    protected void configureShell(Shell newShell)
    {
        super.configureShell(newShell);
        newShell.setText("Application Library List");
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);

        Button ok = getButton(IDialogConstants.OK_ID);
        ok.setText("Apply Changes");
        setButtonLayoutData(ok);

        Button cancel = getButton(IDialogConstants.CANCEL_ID);
        cancel.setText("Cancel");
        setButtonLayoutData(cancel);
    }

    public void okPressed()
    {
        this.close();
    }

    public static void main(String[] args)
    {
        new DummyDialog(new Shell()).open();
    }
}