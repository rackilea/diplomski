public class StackExample
{
    public static void main(String[] args)
    {
        Display display = Display.getDefault();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(3, true));
        shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        for(int i = 0; i < 3; i++)
        {
            createGroup(shell, i);
        }

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    private static void createGroup(Shell parent, int index)
    {
        Group group = new Group(parent, SWT.NONE);
        group.setText("Group " + index);
        group.setLayout(new GridLayout(1, false));
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        for(int i = 0; i < index + 1; i++)
        {
            String text = "";
            for(int j = 0; j < index + 1; j++)
            {
                text += "text";
            }

            Label label = new Label(group, SWT.NONE);
            label.setText(text);
            label.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        }
    }
}