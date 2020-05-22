Button countDownButton2 = (Button) findViewById(R.id.countDown1);      
    countDownButton2.setOnClickListener(new View.OnClickListener() {  

    CountDownTimer timer2;
    public void onClick(View view){

          if(timer2!=null){
              timer2.cancel();
          }
          timer2 = new CountDownTimer(3000,1000){

                @Override
                public void onFinish() {

                    mTimeLabel1.setText("Times Up baby!");
                }

                @Override
                public void onTick(long millisUntilFinished) {                               

                      int seconds = (int) (millisUntilFinished / 1000);
                      int minutes = seconds / 60;
                      seconds = seconds % 60;

                      mTimeLabel1.setText("" + minutes + ":"
                                                      + String.format("%02d", seconds));

                }          
          }.start();

    }
});