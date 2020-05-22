// simple MCVE example class that mocks the functioning of your class
public class MockCopyService extends SwingWorker<Void, Integer> {
    public static final String COPY = "copy";
    private List<File> fileList = new ArrayList<>();

    public MockCopyService() {

    }

    public int getFileListSize() {
        // the real return:
        // return fileList.size();

        // the mock return:
        return 10;
    }

    public void copyImagesToTempFolder() {
        for (int i = 0; i < getFileListSize(); i++) {
            System.out.println("copying file");
            int fileProgress = (100 * i) / getFileListSize();
            // notify listeners
            setProgress(fileProgress);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setProgress(getFileListSize());
    }

    @Override
    protected Void doInBackground() throws Exception {
        copyImagesToTempFolder();
        return null;
    }
}