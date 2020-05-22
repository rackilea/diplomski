SubScene subscene = new SubScene(root, 1024, 768, true, null);
subscene.setFill(Color.GREY);
subscene.setCamera(camera);
StackPane stackPane = new StackPane();
stackPane.getChildren().add(subscene);
subscene.heightProperty().bind(stackPane.heightProperty());
subscene.widthProperty().bind(stackPane.widthProperty());