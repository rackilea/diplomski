public class Shells {
    private static Random r = new Random();
    private static int numDisposals = 0;

    public static void main(String[] args) {
        Display d = Display.getDefault();

        for (int i = 0; i < 5; i++) {
            Shell s = new Shell(d);
            s.open();
            s.addShellListener(new ShellAdapter() {
                @Override
                public void shellClosed(ShellEvent e) {
                    boolean close = r.nextBoolean();
                    if (close) {
                        System.out.println("Alright, shell closing.");
                    } else {
                        System.out.println("Try again.");
                    }
                    e.doit = close;
                }
            });
            s.addDisposeListener(new DisposeListener() {
                @Override
                public void widgetDisposed(DisposeEvent arg0) {
                    numDisposals++;
                }
            });
        }

        while (numDisposals < 5) {
            while (!d.readAndDispatch()) {
                d.sleep();
            }
        }
    }
}