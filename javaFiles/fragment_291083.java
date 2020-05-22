class MyActivity extends Activity {
  public void someMethod() {
    Thread t = new Thread() {
      @override public void run() {
        for(int i = 0; i < 63; i++) {
          TextView tv = new TextView(MyActivity.this);
          tv.setText("What to do");
        }
      }
    };
    t.start();
  }
}