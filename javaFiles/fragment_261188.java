private void updateGUI(final String foo) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            // Here, we can safely update the GUI
            // because we'll be called from the
            // event dispatch thread
            MW.append(foo);
        }
    });
}