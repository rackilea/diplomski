protected TitledPane createTitledPaneCoastalPipe(int index, boolean concentrate){

    TilePane tile = new TilePane(Orientation.HORIZONTAL, 5, 5);
    Label typeLabel = new Label("Тип выпуска");
    ChoiceBox<String> choiceBoxTypeOfPipe = createChoiceBoxTypeOfPipes();

    // remove this line:
    // choiceBoxTypeOfPipe.getSelectionModel().select(1);

    VBox typeContainer = new VBox(typeLabel,choiceBoxTypeOfPipe);

    Label bankLabel = new Label("Берег");
    bankLabel.setId("textWithTooltip");
    Tooltip.install(bankLabel, new Tooltip("Берег, с которого производится выпуск"));
    ChoiceBox<String> choiceBoxCoast = createChoiceBoxCoast();
    choiceBoxCoast.getSelectionModel().select(0);
    VBox bankContainer = new VBox(bankLabel, choiceBoxCoast);

    Label labelCoordinateX = new Label("Точка выпуска (км)");
    labelCoordinateX.setId("textWithTooltip");
    Tooltip.install(labelCoordinateX, new Tooltip("Координата x точки выпуска относительно положения контрольного створа"));

    TextField textFieldCoordinate = new TextField();
    VBox coordinateContainer = new VBox(labelCoordinateX, textFieldCoordinate);

    Label labelLength = new Label("Распределенная часть (м)");
    labelLength.setId("textWithTooltip");
    Tooltip.install(labelLength, new Tooltip("Длина распределенной части выпуска (м)"));
    TextField textFieldLength = new TextField();
    VBox lengthContainer = new VBox(labelLength, textFieldLength);

    tile.getChildren().addAll(typeContainer, bankContainer, coordinateContainer);

    choiceBoxTypeOfPipes.getSelectionModel().selectedIndexProperty().addListener(
        (obs, oldIndex, newIndex) -> {
            // may need different logic here: question is unclear
            if (newIndex.intValue()==1) {
                tile.getChildren().add(lengthContainer);
            }
            if (oldIndex.intValue()==1) {
                tile.getChildren().remove(lengthContainer);
            }
        }
    );

    if (concentrate) {
        choiceBoxTypeOfPipes.getSelectionModel().select(0);
    } else {
        choiceBoxTypeOfPipes.getSelectionModel().select(1);
    }

    TitledPane titledPane = new TitledPane("Параметры выпуска " + (index+1), tile);


    return titledPane;
}