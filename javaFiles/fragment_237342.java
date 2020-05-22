TextField tf = new TextField();
final PseudoClass shortText = PseudoClass.getPseudoClass("short");
final PseudoClass longText = PseudoClass.getPseudoClass("long");
tf.textProperty().addListener((observable, oldValue, newValue) -> {
    tf.pseudoClassStateChanged(shortText, false);
    tf.pseudoClassStateChanged(longText, false);
    if (newValue!=null && !newValue.isEmpty()) {
        if (newValue.length() < 5) {
            tf.pseudoClassStateChanged(shortText, true);
        } else {
            tf.pseudoClassStateChanged(longText, true);
        }
    }
});