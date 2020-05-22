public class bsTimer extends CountDownTimer {

    public bsTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisInFuture) {
        Log.v("bsTimer", "Tick of Progress " + ji + " " + millisInFuture);
        ji+=1;
        j+=1000;
        bsProgressBar.setProgress(j);
        ((TextView)findViewById(R.id.bs_countdown)).setText(convertMillisForCrafting(millisInFuture-ji));

    }

    @Override
    public void onFinish() {
        // TODO Auto-generated method stub

    }

}