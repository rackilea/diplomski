//This pane is the root of the scene, and stretches with the
    //stage. It will hold the smileyPane.
    Pane rootPane = new Pane();

    double smileyRadius = 50.0;

    //This pane is just big enough to hold the outer circle of
    //the smiley face. It holds all the individual pieces that 
    //make up the face.
    Pane smileyPane = new Pane();
    rootPane.widthProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            double smileyPaneStartX = (newValue.doubleValue()/2)-(smileyRadius); 
            smileyPane.setLayoutX(smileyPaneStartX);
        }
    });

    rootPane.heightProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            double smileyPaneStartY = (newValue.doubleValue()/2)-(smileyRadius); 
            smileyPane.setLayoutY(smileyPaneStartY);
        }
    });