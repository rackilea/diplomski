private static final Image VALID_IMG = new Image(MyPresenter.class.getClassLoader().getResource("emblem-default.png").toExternalForm());
private static final Image INVALID_IMG = new Image(MyPresenter.class.getClassLoader().getResource("dialog-error.png").toExternalForm());

public Image validationImage(String token) {
    return isValid(token) ? VALID_IMG : INVALID_IMG;
}

view.tokentxt.textProperty().addListener((observable, oldValue, newValue) -> {
    view.isValidimg.setImage(validationImage(newValue));
});