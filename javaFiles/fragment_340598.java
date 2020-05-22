public static void removeClient(final int i) {
    if (!SwingUtilities.isEventDispatchThread()) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                removeClient(i);
            }
        });
        return;
    }

    // ...