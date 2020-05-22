@Override
public void init() {
    try {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
            //create UI here
            }
        });
}