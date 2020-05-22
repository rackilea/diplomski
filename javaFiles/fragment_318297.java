private static boolean drag = false;

private static int xStart;
private static int yStart;

private static int xEnd;
private static int yEnd;
private static Image outputImage = null;

public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());

    Image inputImage = new Image(display, "baz.png");
    Label output = new Label(shell, SWT.NONE);

    Canvas canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);

    canvas.addListener(SWT.Paint, e -> e.gc.drawImage(inputImage, 0, 0));

    canvas.addListener(SWT.MouseDown, e -> {
        xStart = e.x;
        yStart = e.y;
        drag = true;
    });

    canvas.addListener(SWT.MouseUp, e -> {
        drag = false;

        int x = Math.min(xStart, xEnd);
        int y = Math.min(yStart, yEnd);

        if (outputImage != null && !outputImage.isDisposed())
            outputImage.dispose();

        outputImage = new Image(display, new Rectangle(x, y, Math.abs(xEnd - xStart), Math.abs(yEnd - yStart)));
        GC gc = new GC(inputImage);

        gc.copyArea(outputImage, x, y);
        output.setImage(outputImage);

        gc.dispose();
    });
    canvas.addListener(SWT.MouseExit, e -> drag = false);

    canvas.addListener(SWT.MouseMove, e -> {
        if (drag)
        {
            xEnd = e.x;
            yEnd = e.y;
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
    inputImage.dispose();
    if (outputImage != null && !outputImage.isDisposed())
        outputImage.dispose();
}