JButton.getModel().addChangeListener(new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        ButtonModel model = (ButtonModel) e.getSource();
        if (model.isRollover()) {
            //do something with Boolean variable
        } else {

        }
    }
});