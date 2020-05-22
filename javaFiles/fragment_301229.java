public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    final Image image = display.getSystemImage(SWT.ICON_ERROR);
    final String text = "Button";

    final Button button = new Button(shell, SWT.PUSH);

    GridData data = new GridData();
    float fontHeight = shell.getFont().getFontData()[0].height;
    data.heightHint = image.getImageData().height + (int)fontHeight + 20;
    data.widthHint = 100;

    button.setLayoutData(data);

    button.addListener(SWT.Paint, new Listener() {

        @Override
        public void handleEvent(Event event) {
            GC gc = event.gc;

            int width = ((GridData)button.getLayoutData()).widthHint;
            int height = ((GridData)button.getLayoutData()).heightHint;
            Point textSize = gc.textExtent(text);

            gc.drawText(text, width / 2 - textSize.x / 2, image.getImageData().height - image.getImageData().height / 2 - textSize.y, true);
            gc.drawImage(image, width / 2 - image.getImageData().width / 2, height / 2 - image.getImageData().height / 2 + textSize.y / 2);
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    image.dispose();
    display.dispose();
}