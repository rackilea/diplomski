final TextView txtCount = (TextView) findViewById(R.id.txtCount);

final int secs = 5;
new CountDownTimer((secs + 1) * 1000, 1000) // Wait 5 secs, tick every 1 sec
{
    @Override
    public final void onTick(final long millisUntilFinished)
    {
        txtCount.setText("" + (int) (millisUntilFinished * .001f));
    }
    @Override
    public final void onFinish()
    {
        txtCount.setText("GO!");
    }
}.start();