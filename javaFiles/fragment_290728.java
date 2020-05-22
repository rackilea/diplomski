final Instrumentation i = new Instrumentation();
Thread t = new Thread(){
    public void run(){
      i.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
    }
};
t.start();