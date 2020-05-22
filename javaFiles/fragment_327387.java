switch (message.what) {
  case R.id.decode:
    decode((byte[]) message.obj, message.arg1, message.arg2);
    break;
  case R.id.quit:
    running = false;
    Looper.myLooper().quit();
    break;
}