class YourCoolActivity extends Activity {

  // + getter/setter
  private int index;

  // The rest of the class

 private void yourCoolMethod(){
    for (int i=0; i<=count; i++) {
      this.setIndex(categories.get(i));
      requestItemsByCategory(this.getContext(), categories.get(i), 10, new AsyncHttpResponseHandler() {
          @Override
          public void onSuccess(String response) {
              loadItemsFromJsonString(YourCoolActivity.this.getContext(), response, YourCoolActivity.this.getIndex());
          }
      });
    }
  }
}