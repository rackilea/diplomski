public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Widget");
    shell.setLayout(new GridLayout(1, false));

    final StyledText text = new StyledText(shell, SWT.BORDER);
    text.setText("Text to capture");
    text.setStyleRange(new StyleRange(0, text.getText().length(), display.getSystemColor(SWT.COLOR_RED), display.getSystemColor(SWT.COLOR_BLACK)));
    text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Capture");
    button.addListener(SWT.Selection, new Listener()
    {
        public void handleEvent(Event event)
        {
            Point tableSize = text.getSize();
            GC gc = new GC(text);
            final Image image = new Image(display, tableSize.x, tableSize.y);
            gc.copyArea(image, 0, 0);
            gc.dispose();

            ImageLoader loader = new ImageLoader();
            loader.data = new ImageData[] {image.getImageData()};
            loader.save("swt.png", SWT.IMAGE_PNG);

            image.dispose();
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}