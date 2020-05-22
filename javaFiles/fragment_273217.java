// create a loader
FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
// set this instance as its controller
loader.setController(this);
// load the ui 
Parent root = loader.load();
Scene scene = new Scene(root, 600, 400);
primaryStage.setScene(scene);
primaryStage.setTitle("Stack Overflow Example");
primaryStage.show();
Rectangle r = new Rectangle(100, 100);
// now the field is instantiated and can be accessed without NPE 
anchorPaneOne.getChildren().add(r);