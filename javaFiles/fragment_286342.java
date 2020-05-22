Polygon nose = new Polygon();
  nose.setStroke(Color.BLACK);
  nose.setFill(null);

  //Add initial nose position points
  nose.getPoints().addAll(new Double[]{ 100.0, 90.0, 90.0, 120.0, 110.0, 120.0 });
  pane.widthProperty().addListener(new ChangeListener<Number>(){
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        //The overall pane width changed. Recalculate the position of nose points
        //Actual position calculation left as exercise.
    }
  });

  //Similar thing needs to be done with height. Left as exercise.