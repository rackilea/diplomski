class Matcher {
  ExecutorService threadPool = Executors.newCachedThreadPool();
  private List<BufferedImage> subimages; // populate it yourself
  public static Point match(BufferedImage subimage, BufferedImage image) {
    // Your implementation
  }
  public List<Point> match(BufferedImage image) {
    CompletionService<Point> completionService = new ExecutorCompletionService(threadPool);
    int size = subimages.size();
    List<Point> results = new ArrayList<>(size);
    for (BufferedImage subimage: subimages) {
      completionService.submit(()->match(subimage, image));
    }
    for (int i = 0; i < size; i++) {
      Point point = completionService.take().get();
      if (point != null) {
        results.add(point);
      }
    }
    return results;
  }
}