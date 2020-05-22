public class Shells {
    private static int numDisposals = 0;

    public static void main(String[] args) {
        Display d = Display.getDefault();

        for (int i = 0; i < 5; i++) {
            Shell s = new Shell(d);
            s.open();
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