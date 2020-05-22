static BufferedImage bim;

static Frame frame;

public static void main(String[] args) {

    new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {

                try {
                    final java.awt.Rectangle screenRect = new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                    bim = new Robot().createScreenCapture(screenRect);
                    frame.repaint();
                    Thread.sleep(100);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }).start();

    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    shell.setSize(200, 200);

    Composite composite = new Composite(shell, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    frame = SWT_AWT.new_Frame(composite);
    frame.setLayout(new BorderLayout());
    frame.add(new JPanel() {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bim, 0, 0, this);
        }

    }, BorderLayout.CENTER);
    frame.setVisible(true);

    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}