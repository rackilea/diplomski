// Side note: Are you sure having "main/resources" in the path is correct?
var image = new Image("main/resources/images/jxoPOUxa.gif", true);
var bgImage = new BackgroundImage(
        image,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.DEFAULT,
        new BackgroundSize(1.0, 1.0, true, true, false, false)
);
mainPain.setBackground(new Background(bgImage));