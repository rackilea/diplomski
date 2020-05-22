while(!inputFile.exists()) {
    window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("File was not found.");
    window.setMinWidth(250);
    window.setMaxHeight(100);

    //form
    TextField fileInput = new TextField();
    Button inputButton = new Button("Upload File");
    inputButton.setOnAction(e -> {
        inputFile = new File(fileInput.getText());
        window.close();
    });


    //Layout
    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));
    layout.getChildren().addAll(fileInput, inputButton);

    //Set scene and show in window.
    Scene scene = new Scene(layout, 300, 100);
    window.setScene(scene);
    window.showAndWait();

}