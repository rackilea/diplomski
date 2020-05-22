private CountDownTimer countDownTimer;
    int time = 6;

    private void timeDownTimer() {
        countDownTimer = new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                Log.e("TIK : " , checkDigit(time));
                time--;

            }

            public void onFinish() {
                countDownTimer.cancel();
                test();
            }


        }.start();
    }

    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    private void test(){
        Log.e("TIK : " , "inside my method");
        Toast.makeText(this,"on finish",Toast.LENGTH_LONG).show();
    }