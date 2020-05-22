service1.findDependenciesForListBox1(id1, new AsyncCallback<List<Dependency1DTO>>() {
   public void onFailure(Throwable caught) {
      taskCompletedHandler.notifyOfCompletedTask();
      // exception handling here
   }
   public void onSuccess(List<Dependency1DTO> data) {
      taskCompletedHandler.notifyOfCompletedTask();
      // listBox1 filling here
   }
});