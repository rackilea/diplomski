public class ProgressBarController {

    // ...

    public ReadOnlyObjectProperty<Image> loadImage2 (String filePath) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(1);

        Task<Image> task = new UploadTask(filePath);
        pBar.progressProperty().bind(task.progressProperty());
        this.task.textProperty().bind(task.messageProperty());
        Thread thread = new Thread(task);
        thread.start();
        return task.valueProperty();

    }

    // ...
}