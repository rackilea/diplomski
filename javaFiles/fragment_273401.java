ComboBox<String> cb = new ComboBox<String>(FXCollections.observableArrayList("One", "Two", "Three", "Four"));

cb.valueProperty().addListener(new ChangeListener<String>() {

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        // If the condition is not met and the new value is not null: "rollback"
        if(newValue != null && !newValue.equals("Two")){

            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    cb.setValue(oldValue);
                }});
        }
    }
});