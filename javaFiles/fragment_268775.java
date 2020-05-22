final XYChart.Data<String, Number> data = new XYChart.Data("Value " + i , i);
data.nodeProperty().addListener(new ChangeListener<Node>() {
  @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, Node newNode) {
    if (newNode != null) {
      if (data.getYValue().intValue() > 8 ) {
        newNode.setStyle("-fx-bar-fill: navy;");
      } else if (data.getYValue().intValue() > 5 ) {
        newNode.setStyle("-fx-bar-fill: firebrick;");
      }  
    }
  }
});