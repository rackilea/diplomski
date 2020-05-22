new Thread(() -> {
    Platform.runLater(() -> {
        while(true) {
            if(!files.isEmpty()) {
                fileContainer.getChildren().add(files.poll());
            }
        }
    });
}).start();