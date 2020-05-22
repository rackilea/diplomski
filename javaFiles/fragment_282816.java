public class Controller {

    public ProgressListener createProgressListener(Problem problem, Consumer<Problem> onDownloadComplete) {

        return new ProgressListener() {

            @Override
            public void updateProgress(int bytes, int total) {
                if (bytes == total) {
                    onDownloadComplete.accept(problem);
                }
            }
        };
    }
}