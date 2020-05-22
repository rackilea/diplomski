myDialog.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosed(WindowEvent e) {
        parentFrame.setEnabled(true);
    }
});