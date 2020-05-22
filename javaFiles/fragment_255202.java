for (int i = 0; i < 255; i++) {
    final int x = i;
    Display.getDefault().asyncExec(new Runnable() {
        public void run() {
            setBG(BGHelper(imgHover,x)); //x - alpha
        }
    });
    try {
        Thread.sleep(1);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}