private boolean isSelected(final AbstractButton button) {
    if (SwingUtilities.isEventDispatchThread()) {
        // a shortcut so the AWT thread won't wait for itself
        return button.isSelected();
    }
    final AtomicBoolean isSelected = new AtomicBoolean();
    final CountDownLatch latch = new CountDownLatch(1);
    SwingUtilities.invokeLater(() -> {
        try {
            isSelected.set(button.isSelected());
        } finally {
            latch.countDown();
        }
    });
    try {
        latch.await();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    return isSelected.get();
}