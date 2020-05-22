sourcePane.setOnDragDetected(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Dragboard db = sourcePane.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString("Hello!");
            db.setContent(content);
            System.out.println("Drag detected");
            event.consume();
        }
    });