closeBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        getParent().remove(FilterBox.this);
    }
});