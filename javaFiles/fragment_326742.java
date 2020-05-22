public class CComboDefaultTextTest {

    public static void main(final String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout());

        final Composite baseComposite = new Composite(shell, SWT.NONE);
        baseComposite
                .setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        baseComposite.setLayout(new GridLayout());

        final CCombo combo = new CCombo(baseComposite, SWT.READ_ONLY
                | SWT.BORDER);
        combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        // Be sure to do this before calling setText()
        combo.setItems(new String[] { "item 1", "item 2", "item 3" });
        combo.setText("Default");

        System.out.println(combo.getSelectionIndex());

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

}