ObservableResourceFactory resourceFactory = .... ;

resourceBundle.setResources(...);

Label greetingLabel = new Label();
greetingLabel.textProperty().bind(resourceFactory.getStringBinding("greeting"));