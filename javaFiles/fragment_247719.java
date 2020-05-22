public void setParam(**params**) {
   CountDownTimer countDownTimer = new CountDownTimer(param1, 1000) {
       @Override
       public void onTick(long duration_variable) {
           long millis = duration_variable;
           String hms = String.format("%02d:%02d",

           TimeUnit.MILLISECONDS.toHours(millis),
           TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))
           //TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        );
        timer.setText(hms);
       }
       @Override
       public void onFinish() {
           Toast.makeText(mContext, "timer stopped", Toast.LENGTH_SHORT).show();
       }
   };
   countDownTimer.start();
}