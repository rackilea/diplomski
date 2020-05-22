menuItem.addActionsListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        this.clickHandler(e);
    }
});
menuItem.removeActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        this.clickHandler(e);
    }
});