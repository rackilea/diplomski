public class Sample {

private static Label label;

public static void main(String[] args) {        
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    shell.setBounds(100, 100, 200, 70);
    Button button = new Button(shell, SWT.NONE);
    button.setText("Go");
    button.addListener(SWT.Selection, new Listener(){
        @Override
        public void handleEvent(Event arg0) {
            Shell screenShell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
            screenShell.setMaximized(true);
            screenShell.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
            screenShell.setAlpha(120);
            screenShell.addListener(SWT.MouseDown, new Listener() {
                @Override
                public void handleEvent(Event event) {
                    screenShell.close();                        
                }});
            screenShell.open();
            Display.getCurrent().timerExec(10, new Runnable(){
                @Override
                public void run() {
                    if (!screenShell.isDisposed()) {
                        int x = MouseInfo.getPointerInfo().getLocation().x;
                        int y = MouseInfo.getPointerInfo().getLocation().y;
                        label.setText(x + ":" + y);
                        Display.getCurrent().timerExec(10, this);
                    }
                }});    
        }});

    label = new Label(shell, SWT.NONE);
    shell.open();

    while (!shell.isDisposed ()) {
        if (!display.readAndDispatch ()) display.sleep ();
    }
    display.dispose ();
}