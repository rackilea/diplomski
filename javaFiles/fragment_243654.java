public void button_OnClick(View view) {
    final Button button=findViewById(R.id.button);
    button.setEnabled(false);

    isLooperCalled=false;   //It's new
    final long startTime= Calendar.getInstance().getTime().getTime();
    final Timer timer=new Timer();
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            if(isLooperCalled==false){   //It's new
                Looper.prepare();
                isLooperCalled=true;
            }
            long curentTime=Calendar.getInstance().getTime().getTime();
            long elapsedTime=curentTime-startTime;
            ToastTime(10*60*1000, elapsedTime);
            if(curentTime-startTime>=10*60*1000){  //10 minutes in millisecond
                timer.cancel();
                button.setEnabled(true);
            }
        }
    };
    timer.schedule(task, 500, 2000);
}

private void ToastTime(long totalTime, long elapsedTime){
    final int remainInSec = (int)(totalTime - elapsedTime) / 1000;
    if(remainInSec>0) {   //It's edited
        Toast.makeText(this, String.valueOf(remainInSec) + " seconds to enable button", Toast.LENGTH_SHORT).show();
    }
}