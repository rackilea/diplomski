public class FirstLinePaddedTextAread extends javafx.scene.control.TextArea {
    private int offset;

    public FirstLinePaddedTextAread(String padded) {
        this.offset = padded.length();
        this.setText(padded);
        this.positionCaret(offset);

        this.setOnKeyPressed(event -> consumeIfCaretIsOnReadOnlyArea(event));
        this.setOnKeyTyped(event -> consumeIfCaretIsOnReadOnlyArea(event));
        this.setOnKeyReleased(event -> consumeIfCaretIsOnReadOnlyArea(event));
    }

    private void consumeIfCaretIsOnReadOnlyArea(javafx.scene.input.KeyEvent event) {
        if (getCaretPosition() < offset) {
            if (!event.getCode().isNavigationKey())
                event.consume();

        } else if (getCaretPosition() == offset) {
            if (event.getCode() == javafx.scene.input.KeyCode.DELETE
                    || event.getCode() == javafx.scene.input.KeyCode.BACK_SPACE) {
                event.consume();
            }
        }
    }
}