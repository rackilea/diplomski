...
public static void main(final String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display); // Already creating a Shell here

    display.asyncExec(new Runnable() {
        public void run() {
            final Shell shell = SWT_AWT.new_Shell(display, canvas);  // Remove this
            shell.setSize(800, 600);
...