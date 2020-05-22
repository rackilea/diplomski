private void disposeWindow(final java.awt.Window window) {
    SwingEnvironment.runOnEventDispatchingThread(new Runnable() {
        @Override
        public void run() {
            window.dispose();
            window.setVisible(false);
            window.removeNotify();

            String oldName = window.getName();
            if (oldName == null) {
                oldName = "unnamed";
            }

            if (!oldName.startsWith("dead-")) {
                window.setName("dead-" + oldName);
            }
        }
    });
}