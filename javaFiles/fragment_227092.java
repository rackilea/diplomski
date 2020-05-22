new Thread(new Runnable() {
    @Override
    public void run() {
        WritableImage image = new WritableImage(...);
        /// draw on image....
        myImageProperty.set(image);
    }
});