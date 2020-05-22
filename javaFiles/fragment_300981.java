checkbox.addSelectionListener(new SelectionAdapter() {
    @Override
    public void widgetSelected(SelectionEvent e) {
        yourComposite.setVisible(checkbox.getSelection());
        yourComposite.layout();
    }
});