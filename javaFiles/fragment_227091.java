public void changed(ObservableValue<? extends Image> observable,
        Image oldValue, Image newValue) {
    Platform.runLater(new Runnable() {
        @Override
        public void run() {
            this.imageView.setImage(newValue);
        }
    });
}