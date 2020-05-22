...
    // GridPane group = new GridPane(); ---> you don't need a new one
    // group.add(contnr, 0, 0);
    // group.add(timePicker, 0, 1);
    this.add(contnr, 0, 0);
    this.add(timePicker, 0, 1);
    timePicker.toFront();

    // Scene scene = group.getScene();
    // scene.setOnMousePressed((event) -> {
    // hidetimePicker();
    // arrow.setRotate(0);
    // });

    // return group;
}