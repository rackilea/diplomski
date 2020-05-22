private void timee(){

        MalibuCountDownTimer countDownTimer=new MalibuCountDownTimer(5000, 1000);
            countDownTimer.start();

}
public class MalibuCountDownTimer extends CountDownTimer {

    public MalibuCountDownTimer(long startTime, long interval) {
        super(startTime, interval);
    }

    @Override
    public void onFinish() {
        Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        j++;
        if(j<=5)
        start();
    }

    @Override
    public void onTick(long millisUntilFinished) {
        m_tv_emp.setText("Time remain:" + millisUntilFinished / 1000);
    }
}