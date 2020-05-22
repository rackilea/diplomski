addButton.setEnabled(false);
tree.addTreeSelectionListener(new TreeSelectionListener() {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        addButton.setEnabled((tree.getSelectionPath().getPathCount() == 2));
    }
});