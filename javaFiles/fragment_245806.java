button.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
        value.set((int)value.get()/10 + 
        /**
        * To get the decimal part
        */
        value.get() - (int)value.get());
    }
});