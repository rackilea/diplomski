private XYChart.Data CoLDatum(Double x, Double y){
    final XYChart.Data data = new XYChart.Data(x, y);
    ImageView myImage = new ImageView(new Image(getClass().getResource("style/redX.png").toExternalForm()));
    data.setNode(myImage);
    data.getNode().setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent mouseEvent) {
          main_label.setText("Some Text.");
        }
      });
      data.getNode().setOnMouseExited(new EventHandler<MouseEvent>(){
        @Override public void handle(MouseEvent mouseEvent) {
          main_label.setText("");
        }
      });

    return data;
  }