int time=30;
TextView textTimer = (TextView)findViewById(R.id.timer);

new CountDownTimer(30000, 1000) {

    public void onTick(long millisUntilFinished) {  
        textTimer.setText("0:"+checkDigit(time));
        time--;         
    }

    public void onFinish() {
        textTimer.setText("try again");
    }

}.start();



public String checkDigit(int number) {
    return number <= 9 ? "0" + number : String.valueOf(number);
}