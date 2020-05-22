public void start(Stage primaryStage)throws Exception{
    totalPercent = new Label();

    totalPercent.textProperty().bind(Methods.percentProperty().asString());

    final Color color560 = Color.web("#ff7700");
    final Color color100 = Color.web("#59ff00");
    totalPercent.textFillProperty().bind(Bindings.createObjectBinding(() -> {
              int percent = Methods.getPercent();
              if(percent <  50) {
                  return Color.RED;
              } else if(percent < 60) {
                  return color60;
              }else if (percent < 100){
                  return color100;
              } else {
                  return Color.BLACK;
              }
          }, Methods.percentProperty()));
}