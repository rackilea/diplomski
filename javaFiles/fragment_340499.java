@Override
public void start(Stage primaryStage) throws Exception{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    Parent root = loader.load();
    Controller controller = loader.getController();

    // ...

    scene.setOnDragDropped(new EventHandler<DragEvent>() {
        @Override
        public void handle(DragEvent event) {

            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                success = true;
                String filePath = null;
                for (File file:db.getFiles()) {
                    filePath = file.getAbsolutePath();
                    System.out.println(filePath);
                    // Controller controller = new Controller();
                    //Part where it crashes,
                    controller.buttonTest.setVisible(false);
                }
            }
            event.setDropCompleted(success);
            event.consume();
        }
    });

    // ...

}