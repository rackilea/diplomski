public void updateProgress(String updateString) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            jLabel6.setText(updateString);
        }
    });
}