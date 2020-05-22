JButton.getModel().addChangeListener(new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        ButtonModel model = (ButtonModel) e.getSource();
        if (model.isRollover()) {
            //doSomething
        } else if (model.isPressed()) {
           //doSomething
        }  // etc
    }
});