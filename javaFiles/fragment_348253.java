ObservableList<String> names = FXCollections.observableArrayList("1","2","3","4","5","6","7");
    final ListView<String> listView = new ListView<String>(names);

    stage.setOnShown(new EventHandler<WindowEvent>(){
        boolean hasRun = false;
        @Override
        public void handle(WindowEvent arg0) {
            if(!hasRun){
                for (Node node: listView.lookupAll(".scroll-bar")) {
                    if (node instanceof ScrollBar) {
                        final ScrollBar bar = (ScrollBar) node;
                        bar.valueProperty().addListener(new ChangeListener<Number>() {
                            @Override public void changed(ObservableValue<? extends Number> value, Number oldValue, Number newValue) {
                                System.out.println(bar.getOrientation() + " " + newValue);
                            }
                        });
                    }
                }
                hasRun = true;
            }
        }});