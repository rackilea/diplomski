@FXML
private void initialize() {
    btnMainOne.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {

            Stage primaryStage = (Stage)btnMainOne.getScene().getWindow();

            try {
                Stage stage = new Stage();
                stage.setTitle("Second stage");
                stage.setScene(new Scene(root, 450, 450));

                stage.setOnHidden(e -> primaryStage.show());

                stage.show();

                primaryStage.hide();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    });

}