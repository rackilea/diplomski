public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
            path.getElements()
                    .add(new MoveTo(mouseEvent.getX(), mouseEvent.getY()));
        } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            path.getElements()
                    .add(new LineTo(mouseEvent.getX(), mouseEvent.getY()));
        }

        // Here is an answer
        path.toBack();

    }