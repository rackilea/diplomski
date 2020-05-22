toggleButton.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
        event.consume();
    });
    toggleButton.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
        if ( event.getCode() == KeyCode.SPACE ) {
            event.consume();
        }
    });