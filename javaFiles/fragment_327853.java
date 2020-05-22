public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());

    CDateTime dateTime = new CDateTime(shell, CDT.DATE_MEDIUM | CDT.DROP_DOWN);
    dateTime.setPattern(" dd/MM/yyyy");
    dateTime.setSelection(new Date());

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}