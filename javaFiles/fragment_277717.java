public static void addTimeout(final Component c, long timeout) {
    Executors.newSingleThreadScheduledExecutor().schedule(() -> {
        if (c.isVisible()) {
            SwingUtilities.invokeLater(() -> {
                c.setVisible(false);
            });
        }
        return null;
    }, timeout, TimeUnit.MILLISECONDS);
}