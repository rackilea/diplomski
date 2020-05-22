public void button_OnClick(View view) {
    Button button=findViewById(R.id.button);
    button.setEnabled(false);

    final long startTime= Calendar.getInstance().getTime().getTime();
    final Timer timer=new Timer();
    final Activity activity = this;
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            long curentTime=Calendar.getInstance().getTime().getTime();
            long elapsedTime=curentTime-startTime;
            ToastTime(10*60*1000, elapsedTime);
            if(curentTime-startTime>=10*60*1000){  //10 minutes in millisecond
                timer.cancel();
                EnableButton();
            }
        }
    };
    timer.schedule(task, 500, 2000);
}