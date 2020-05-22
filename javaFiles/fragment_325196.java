@FXML
    private Text textDescr;

    private StringProperty textProperty = new SimpleStringProperty();  

    @FXML
    void initialize() {
            assert textDescr != null : "fx:id=\"textDescr\" was not injected: check your FXML file 'TestView.fxml'.";
           textDescr.textProperty().bind(textProperty);
    }

    public ReadOnlyStringProperty textProperty(){
          return textProperty;
    }