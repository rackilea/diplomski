clear.addActionListner(new ActionListener() {
    @Override
    public void actionPreformed(ActionEvent arg0) {
        drawablePane.clear();
    }
});

undo.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        drawablePane.undo();
    }
});