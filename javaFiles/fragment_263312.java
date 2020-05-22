WebTask<String> task = new WebTask<String>() {
   public void handle() {
      WebReaderResult<String> result = getWebReaderResult();

      // TODO : handle task and set result here result.getResult();
   }
};
WebControllerCallback<String> callback = new WebControllerCallback<String>() {
   public void done(String result) {
      // TODO : update UI here from result value
   }
};

WebController.getInstance().handleTask(task, callback);