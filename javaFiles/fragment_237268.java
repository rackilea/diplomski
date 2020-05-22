textArea.textProperty().addListener((obs, oldText, newText) -> {
    if (newText.length() > oldText.length()) {
        Platform.runLater(() ->
            textArea.selectRange(oldText.length(), newText.length()));
    }
});