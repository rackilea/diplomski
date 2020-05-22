ChangeListener listener = new ChangeListener(){
    @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            // your code here
        }
};
radio_money2.selectedToggleProperty().addListener(listener);
radio_money2.selectedToggleProperty().removeListener(listener);