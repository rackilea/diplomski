JFileChooser fileChooser = new JFileChooser() {
    private static final long serialVersionUID = 1;

    @Override
    public JDialog createDialog(Component parent) {
        JDialog dialog = super.createDialog(parent);
        dialog.setMinimumSize(new Dimension(600, 600));
        return dialog;
    }
};