try {
    SwingUtilities.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            render();
        }
    });
} catch (InvocationTargetException | InterruptedException e) {
    running = false;
    System.err.println("Render interrupted");
}