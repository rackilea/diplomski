// Declare this in your activity
Runnable r;

//change your onClick to make and post a recursive runnable.
public void onClick(final View v) { //<-- need to make v final so we can refer to it in the inner class.
    switch (v.getId()) {
    case R.id.button_Timer:
        Log.e("MainActivity", "Clicked");
        r = new Runnable(){
            public void run(){
                if (mService != null){
                    str2 = Ef.getText().toString();
                    str2 = str2.substring(0, 0) + "E" + str2.substring(0, str2.length());
                    mService.sendAlert(mDevice, str2);
                    v.postDelayed(r, 60 * 1000);
                }
            }
        };
        //fire the first run. It'll handle the repeating
        v.post(r);
        break;

    default:
        Log.e(TAG,"wrong Click event");
        break;
    }
}