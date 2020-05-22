public void setIconLabel(final Icon icon) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            myLabel.setIcon(icon);
        }
    });
}