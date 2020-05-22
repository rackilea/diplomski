public static void removeClient(int i) {
    if (!SwingUtilities.isEventDispatchThread()) {
        SwingUtilities.invokeLater(() -> removeClient(i));
        return;
    }

    // ...