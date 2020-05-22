super.onCreate(savedInstanceState);
setContentView(starting.rt.R.layout.relationship);
layout = (RelativeLayout) findViewById(starting.rt.R.id.relativelayout1);
setred = false;

timer = new Thread() {

public void run() {
    try {
        sleep(7000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        MyActivity.this.runOnUiThread(new Runnable() {

        public void run() {
          if (setred) {
            setred = false;
            layout.setBackgroundResource(starting.rt.R.drawable.cosmos);
          } else {
            setred = true;
            layout.setBackgroundResource(starting.rt.R.drawable.red);
          }
        }
    });
  }
 }
};
timer.start();