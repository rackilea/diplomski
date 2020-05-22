public void start(Stage stage) throws Exception {
   Group root = new Group();
   Scene scene = new Scene(root);

   Button button = new Button("Hello World");
   root.getChildren().add(button);

   root.applyCss();
   root.layout();

   double width = button.getWidth();
   double height = button.getHeight();

   System.out.println(width + ", " + height);

   stage.setScene(scene);
   stage.show();
}