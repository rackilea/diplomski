Image image = new Image("/images/nfc.png");
if (image.isError()) {
    System.out.println(image.getException());
} else {
    image.errorProperty().addListener((observable, oldValue, newValue) -> {
        if (image.isError()) {
            System.out.println(image.getException());
        }
    });
}