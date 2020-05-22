final List<String> originalFileContents = new ArrayList<String>();
final String filePath = "C:/Users/BackSlash/Desktop/asd.txt";

FileListener fileListener = new FileListener() {

    @Override
    public void fileDeleted(FileChangeEvent paramFileChangeEvent)
    throws Exception {
        // use this to handle file deletion event

    }

    @Override
    public void fileCreated(FileChangeEvent paramFileChangeEvent)
    throws Exception {
        // use this to handle file creation event

    }

    @Override
    public void fileChanged(FileChangeEvent paramFileChangeEvent)
    throws Exception {
        System.out.println("File Changed");
        //get new contents
        List<String> newFileContents = new ArrayList<String> ();
        getFileContents(filePath, newFileContents);
        //get the diff between the two files
        Patch patch = DiffUtils.diff(originalFileContents, newFileContents);
        //get single changes in a list
        List<Delta> deltas = patch.getDeltas();
        //print the changes
        for (Delta delta : deltas) {
            System.out.println(delta);
        }
    }
};

DefaultFileMonitor monitor = new DefaultFileMonitor(fileListener);
try {
    FileObject fileObject = VFS.getManager().resolveFile(filePath);
    getFileContents(filePath, originalFileContents);
    monitor.addFile(fileObject);
    monitor.start();
} catch (InterruptedException ex) {
    ex.printStackTrace();
} catch (FileNotFoundException e) {
    //handle
    e.printStackTrace();
} catch (IOException e) {
    //handle
    e.printStackTrace();
}