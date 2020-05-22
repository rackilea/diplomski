@FXML
public void playButton() {
        Task task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                for (final ImageView image : imageList) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            previewBoxLabel.setGraphic(image);
                        }
                    });

                    Thread.sleep((long) (1000 / frameRate));
                }
                return null;
            }
        };
        new Thread(task).start();
    }
}