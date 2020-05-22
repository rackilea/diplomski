Thread thread = new Thread() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                imageView.setX(e.getX()); // this will now run fine
                imageView.setY(e.getY());
            });
        }
    };