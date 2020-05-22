public static class Camera {
    private final BlockingQueue<Object> pictureQueue;

    public Camera(BlockingQueue<Object> pictureQueue) {
        this.pictureQueue = pictureQueue;
    }

    public void takePicture() {
        System.out.println("Taking picture...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pictureQueue.put(new Object());

        System.out.println("Finished taking picture.");
    }

}