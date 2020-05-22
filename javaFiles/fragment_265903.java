public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);

    Listener l = new Listener()
    {
        Point origin;

        public void handleEvent(Event e)
        {
            switch (e.type)
            {
                case SWT.MouseDown:
                    origin = new Point(e.x, e.y);
                    break;
                case SWT.MouseUp:
                    origin = null;
                    break;
                case SWT.MouseMove:
                    if (origin != null)
                    {
                        Point p = display.map(shell, null, e.x, e.y);
                        shell.setLocation(p.x - origin.x, p.y - origin.y);
                    }
                    break;
            }
        }
    };
    shell.addListener(SWT.MouseDown, l);
    shell.addListener(SWT.MouseUp, l);
    shell.addListener(SWT.MouseMove, l);

    shell.setSize(400, 300);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}