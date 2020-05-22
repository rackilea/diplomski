toggleButton.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent event) {
            if (toggleButton.isSelected()){
                toggleButton.setText("ON");
            } else {
                toggleButton.setText("OFF");
            }
        }
    });