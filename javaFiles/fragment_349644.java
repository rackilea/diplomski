// result varible define as a public
    long result = 80;
    mCalculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            new CountDownTimer(result * 1000, 100) {
                public void onTick(long millisUntilFinished) {
                    // its start with 1 if you want start with 0 then replace with below code
                    //int sec = (int) (result - (millisUntilFinished / 1000)-1);
                    int sec = (int) (result - (millisUntilFinished / 1000));
                    waveLoadingView.setProgressValue(sec);
                    waveLoadingView.setCenterTitle(String.valueOf(result)); //result is the value from randomize 60 to 80 .

                }

                public void onFinish() {
                }
            }.start();

        }
    });