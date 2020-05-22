public static void loadWithExecutor(File[] images) {
    ExecutorService service = Executors.newFixedThreadPool(2);
    List<ImageLoadingTask> tasks = new ArrayList<>(images.length);
    for (File file : images) {
        tasks.add(new ImageLoadingTask(file));
    }
    try {
        List<Future<BufferedImage>> results = service.invokeAll(tasks);
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
    service.shutdown();
}

public static class ImageLoadingTask implements Callable<BufferedImage> {

    private File file;

    public ImageLoadingTask(File file) {
        this.file = file;
    }

    @Override
    public BufferedImage call() throws Exception {
        return ImageIO.read(file);
    }

}