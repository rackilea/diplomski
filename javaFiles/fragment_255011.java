Scene scene = new Scene(root,600,300);
scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
primaryStage.setScene(scene);
primaryStage.show();

marqueeLeft.animate();
marqueeRight.animate();