final ExecutionContext ec = system.dispatcher();

future.onSuccess(new OnSuccess<String>() {
  public void onSuccess(String result) {
    if ("bar" == result) {
      //Do something if it resulted in "bar"
    } else {
      //Do something if it was some other String
    }
  }
}, ec);