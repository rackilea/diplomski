public interface ClosingListener {
    public boolean allowClosing();
}

public MainClass {
    private ArrayList<ClosingListener> closingListeners = new ArrayList<ClosingListener>();

    public MainClass() {
        JFrame frame = new JFrame();
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                boolean canClose = true;
                for (ClosingListener closingListener : closingListeners) {
                    if (!closingListener.allowClosing()) {
                        canClose = false;
                        break;
                    }
                }

                if (canClose) {
                    System.exit(0);
                }
            }
        });
    }

    public void addClosingListener(ClosingListener closingListener) {
        closingListeners.add(closingListener);
    }
}