public void change(int aantal) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            if (aantal < progressBar.getMaximum() && aantal >= 0) {
                progressBar.setValue(aantal);
            }
        }
    });
}