Image img = new Image(file.getAbsoluteFile().toURI().toString());
BackgroundImage bgImg = new BackgroundImage(img, 
    BackgroundRepeat.NO_REPEAT,
    BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT,
    BackgroundSize.DEFAULT);
borderPane.setBackground(new Background(bgImg));