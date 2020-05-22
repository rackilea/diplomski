public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final SashForm sashForm = new SashForm(shell, SWT.HORIZONTAL);

    Text text1 = new Text(sashForm, SWT.CENTER);
    text1.setText("Text in pane #1");
    Text text2 = new Text(sashForm, SWT.CENTER);
    text2.setText("Text in pane #2");

    final SashForm sashForm2 = new SashForm(sashForm, SWT.VERTICAL);

    final Label labelA = new Label(sashForm2, SWT.BORDER | SWT.CENTER);
    labelA.setText("Label in pane A");
    final Label labelB = new Label(sashForm2, SWT.BORDER | SWT.CENTER);
    labelB.setText("Label in pane B");

    sashForm.setWeights(new int[] { 1, 2, 3 });

    new Label(shell, SWT.NONE).setText("Label");

    shell.pack();
    shell.setSize(400, 300);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}