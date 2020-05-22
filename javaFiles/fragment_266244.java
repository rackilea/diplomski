public class SimpleCompletableFuture {
    public static void main(String... args) {
        testDownload();
    }

    private static void testDownload() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> downloadMock())
                .thenApply(SimpleCompletableFuture::processDownloaded);
        System.out.println(future.join());
    }

    private static String downloadMock() {
        try {
            Thread.sleep(new Random().nextInt() + 1000); // mock the downloading time;
        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        }
        return "Downloaded";
    }

    private static String processDownloaded(String fileMock) {
        System.out.println("Processing " + fileMock);
        System.out.println("Done!");
        return "Processed";
    }
}