TextField textField = ...;
    textField.setTextChangeEventMode(TextChangeEventMode.EAGER);
    textField.addTextChangeListener(new TextChangeListener() {
        @Override
        public void textChange(TextChangeEvent event) {
            String text = event.getText();
            // sync with other component
        }
    });