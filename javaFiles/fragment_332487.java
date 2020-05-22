JButton.getModel().addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isRollover()) {
                button.setIcon(icon());
            } else {
                button.setIcon(iconA());
            } etc ...//  if (model.isPressed()) {
         }
    });