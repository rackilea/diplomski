public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    shell.setFullScreen(true);
    shell.setAlpha(0);

    final Listener sendSomewhere = new Listener() {

        @Override
        public void handleEvent(Event event) {
            int x = event.x;
            int y = event.y;

            int eventType = event.type;

            System.out.println(x + " " + y + ": " + eventType);

            // send the coordinates to your other device
        }
    };

    int[] events = new int[] {SWT.MouseDown, SWT.MouseUp, SWT.MouseDoubleClick, SWT.Selection};

    for(int event : events)
    {
        display.addFilter(event, sendSomewhere);
    }


    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}