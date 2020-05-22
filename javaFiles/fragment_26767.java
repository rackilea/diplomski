public class DrawExample
{
    private static boolean drag = false;
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;

    public static void main(String[] args)
    {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Drawing Example");

        final Canvas canvas = new Canvas(shell, SWT.NONE);
        canvas.setSize(150, 150);
        canvas.setLocation(20, 20);
        shell.open();
        shell.setSize(200, 220);

        canvas.addListener(SWT.MouseDown, new Listener() {

            @Override
            public void handleEvent(Event event) {
                startX = event.x;
                startY = event.y;

                drag = true;
            }
        });

        canvas.addListener(SWT.MouseUp, new Listener() {

            @Override
            public void handleEvent(Event event) {
                endX = event.x;
                endY = event.y;

                drag = false;

                canvas.redraw();
            }
        });

        canvas.addListener(SWT.MouseMove, new Listener() {

            @Override
            public void handleEvent(Event event) {
                if(drag)
                {
                    endX = event.x;
                    endY = event.y;

                    canvas.redraw();
                }
            }
        });

        canvas.addListener(SWT.Paint, new Listener() {

            @Override
            public void handleEvent(Event event) {
                if(drag)
                {
                    GC gc = event.gc;

                    gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
                    gc.setAlpha(128);

                    int minX = Math.min(startX, endX);
                    int minY = Math.min(startY, endY);

                    int maxX = Math.max(startX, endX);
                    int maxY = Math.max(startY, endY);

                    int width = maxX - minX;
                    int height = maxY - minY;

                    gc.fillRectangle(minX, minY, width, height);
                }
            }
        });

        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}