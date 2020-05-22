comboBox.getEditor().focusedProperty().addListener(
    new ChangeListener<Boolean>() {
        @Override
        public void changed(final ObservableValue<? extends Boolean> observable, 
                            final Boolean oldValue, final Boolean newValue) {
            if (newValue) {
                Platform.runLater(
                    new Runnable() {
                        @Override
                        public void run() {
                            comboBox.getEditor().selectAll();
                        }
                    }
                );
            }
        }
    }
);