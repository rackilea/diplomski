private Handler mHandler = new Handler();
private boolean wasRun = true;
mHandler.postDelayed(new Runnable() {
@Override
public void run() {
    if(wasRun){               
       //whatever you want to do if run
       //you can add you want to increase variable here
    }
    mHandler.postDelayed(this, 1000);
}
}, 1000); // 1 seconds