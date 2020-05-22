Handler myHandler = new Handler(Looper.getMainLooper()) {
  @Override
  public void handleMessage(Message msg) {
    switch (msg.what) {
      case MY_MESSAGE_TYPE:
        //do something with the message
        break;
    }
  }
}

Message myMessage = myHandler.obtainMessage(MY_MESSAGE_TYPE, somePayloadObject);
myHandler.sendMessage(myMessage);