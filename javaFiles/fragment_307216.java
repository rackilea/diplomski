BackgroundSize size = new BackgroundSize(
        50,
        50,
        true,
        true,
        true,
        false);
BackgroundImage image = new BackgroundImage(new Image("../view/Close.png"),
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        size);

deleteButton.setBackground(new Background(image));