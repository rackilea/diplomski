public class ch2q17 {

    public static class JavaFxWindow extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            Group root = new Group();
            primaryStage.setScene(new Scene(root, 1024, 768));
            primaryStage.setTitle("Test Window");
            //root.getChildren().add(vb);
            System.out.println("Showing stage...");
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

    public static void main(String[] args) {
        JavaFxWindow.main(args);
    }
}