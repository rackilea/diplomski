stringProperty = new SimpleStringProperty();
    stringProperty.setValue("");
    tablelbl.setText(stringProperty.getValue());
    stringProperty.addListener(new ChangeListener(){
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            showselectedlist();
        }
    });