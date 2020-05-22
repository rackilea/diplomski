for (int i=0; i < NUM_OP_BUTTONS; i++) {
    operatorImages[i] = new ImageView(
            new Image(Java.class.getResourceAsStream(
                    "art" + File.separator + "Square.png")));
    operatorButtons[i] = new Button();
    operatorButtons[i].setGraphic(operatorImages[i]);
    operatorButtons[i].setPadding(Insets.EMPTY);
    operatorButtons[i].setId("orange-"+(i));
    flow.getChildren().add(operatorButtons[i]);
}