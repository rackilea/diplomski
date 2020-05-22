private static String textContent = "";

public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout(SWT.VERTICAL));

    Text text = new Text(shell, SWT.BORDER);

    text.addListener(SWT.FocusOut, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            Text text = (Text) e.widget;
            textContent = text.getText();

            text.setText(textContent.substring(0, Math.min(10, textContent.length())) + "...");
        }
    });

    text.addListener(SWT.FocusIn, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            Text text = (Text) e.widget;

            text.setText(textContent);
        }
    });

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Lose focus");

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}