public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout(SWT.VERTICAL));

    final SashForm sashForm = new SashForm(shell, SWT.HORIZONTAL);

    Text text = new Text(sashForm, SWT.CENTER);
    text.setText("Text in pane #1");
    text = new Text(sashForm, SWT.CENTER);
    text.setText("Text in pane #2");
    text = new Text(sashForm, SWT.CENTER);
    text.setText("Text in pane #3");

    sashForm.setWeights(new int[] { 1, 2, 3 });

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Get width");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            int overallWidth = sashForm.getClientArea().width;
            int[] widths = new int[sashForm.getSashWidth()];

            int overallWeight = 0;

            for (int i : sashForm.getWeights())
            {
                overallWeight += i;
            }

            for (int i = 0; i < widths.length; i++)
            {
                widths[i] = Math.round(overallWidth * (1f * sashForm.getWeights()[i] / overallWeight));
            }

            System.out.println(Arrays.toString(widths));
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        while (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
}