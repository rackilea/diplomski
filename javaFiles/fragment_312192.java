for (int i=0; i < NUM_BUTTONS; i++) {
    centerImages[i] = new ImageView(
            new Image(Java.class.getResourceAsStream(
                    "art" + File.separator + "Square.png")));
    centerButtons[i] = new Button();
    centerButtons[i].setGraphic(centerImages[i]);
    centerButtons[i].setPadding(Insets.EMPTY);
    centerButtons[i].setId("button-"+(i));
    flow.getChildren().add(centerButtons[i]);
}