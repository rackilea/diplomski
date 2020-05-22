private static Shell shell;
private static ProgressBar bar;

public static void Pv7(Button ok, Shell shell2) 
{
    shell=shell2;

    if(bar != null && !bar.isDisposed())
        bar.dispose();

    bar = new ProgressBar(shell, SWT.SMOOTH);

    shell.setLayout(new RowLayout()); 
    shell.setSize(1500, 1000);

    pb3.setSelection(500);

    Label label3 = new Label(shell, SWT.NULL);
    label3.setAlignment(SWT.LEFT);
}

public static void disposeProgressBar()
{
    if(bar != null && !bar.idDisposed())
        bar.dispose();
}