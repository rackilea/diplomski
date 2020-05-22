@Override
public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("GridPane Experiment");
    GridPane gridPane = new GridPane();

    final int rowCount = 5;
    TextField[][] textFields = new TextField[rowCount][0];
    final Insets hboxPadding = new Insets(5);
    final Insets labelMargin = new Insets(0, 15, 0, 15);

    for (int i = 0; i < rowCount; i++) {
        VBox vboxgrid2 = new VBox();

        RadioButton rbYes = new RadioButton("Yes");
        RadioButton rbNo = new RadioButton("No");
        Label howmanyLabel = new Label("How many?");
        HBox.setMargin(howmanyLabel, labelMargin);
        TextField howManytxtB = new TextField();

        HBox hboxgrid = new HBox(rbYes, rbNo, howmanyLabel, howManytxtB);
        hboxgrid.setPadding(hboxPadding);

        final int rowIndex = i;

        howManytxtB.setOnAction(event -> {
            vboxgrid2.getChildren().clear();
            int howManyNum = Math.max(0, Integer.parseInt(howManytxtB.getText()));
            TextField[] fields = new TextField[howManyNum];
            for (int row = 0; row < howManyNum; row++) {
                //creating rows for entering the new entities
                TextField name = new TextField();
                ComboBox cb = new ComboBox(); //empty cb for now
                name.setPromptText("Enter name of the new Entity");
                name.setMinWidth(200);
                HBox innerRowbox = new HBox(name, cb);
                vboxgrid2.getChildren().add(innerRowbox);

                fields[row] = name;
            }
            textFields[rowIndex] = fields;
        });

        VBox mainVBox = new VBox(hboxgrid, vboxgrid2);
        gridPane.addRow(i, new Label("row" + i), mainVBox);
    }

    Button saveButton = new Button("save content");

    saveButton.setOnAction(e -> {
        TextField[] secondRowFields = textFields[1];
        if (secondRowFields.length == 0) {
            System.out.println("no TextFields in row1");
        } else {
            for (TextField textField : secondRowFields) {
                System.out.println(textField.getText());
            }
        }
    });

    gridPane.add(saveButton, 1, rowCount);
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    Scene scene = new Scene(gridPane, 500, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
}