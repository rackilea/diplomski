final Label myLabel = new Label("test");
final Pane myPane = new Pane(myLabel);

System.out.println(myLabel.getWidth());

stage.setScene(new Scene(myPane, 640, 480));
stage.show();

System.out.println(myLabel.getWidth());