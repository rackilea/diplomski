list.addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        text.setText(list.getSelectedValue().toString());
    }
});