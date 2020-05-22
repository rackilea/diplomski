public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());

    final Canvas canvas = new Canvas(shell, SWT.NONE);

    Menu menu = new Menu(canvas);
    final MenuItem item = new MenuItem(menu, SWT.NONE);
    item.setText("MenuItem");
    canvas.setMenu(menu);

    canvas.addListener(SWT.MenuDetect, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            Point location = canvas.toControl(event.x, event.y);

            item.setEnabled(location.x <= canvas.getBounds().width / 2f);
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