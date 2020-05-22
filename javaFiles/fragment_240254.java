Task<List<String>> signingTask = new Task<List<String>>() {
    @Override
    public List<String> call() throws Exception {
        List<String> files = new ArrayList<String>();

        for (File unsignedFile : fWrapper.getFiles()) {
            String targetFileStr = targetPath + "/" + unsignedFile.getName();
            File signedFile = signer.signUDF(unsignedFile);
            files.add(targetFileStr);

            signedFile.renameTo(new File(targetFileStr));

            Platform.runLater(() -> Browser.webEngine.executeScript("signedSuccessfully('" + unsignedFile.getName() + " is signed.')"));
        }
        return files ;
    }
};

signingTask.setOnSucceeded(e -> {
    // this is executed on the FX Application Thread when the task completes successfully
    List<String> signedFiles = signingTask.getValue();
    // do something with signedFiles...
});

signingTask.setOnFailed(e -> {
    Throwable exception = signingTask.getException();
    // this is executed on the FX Application Thread if the task throws an exception
    // inform user something went wrong, etc...
});

Thread t = new Thread(signingTask);
t.start();