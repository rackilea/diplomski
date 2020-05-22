public static boolean showMessageCheckToUpload() {
   @SuppressWarnings({ "unchecked", "rawtypes" })
   final FutureTask query = new FutureTask(new Callable() {
      @Override
      public Object call() throws Exception {
         boolean uploadDisk = MessageBoxTwoChoicesController.showDialogBox(
                    stage, "Upload disk",
                    "Do you want to upload the current Disk to the server?", "Yes", "No");
         return uploadDisk;
      }
    });
    Platform.runLater(query);
    try {
       return (boolean) query.get();
    } catch (InterruptedException | ExecutionException e) {
       return false;
    }
}