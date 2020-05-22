private void countDown()
{
    counter = lengthOfActivities;
    if (sessionsLeft > 0) {
        new CountDownTimer((lengthOfActivities * 1000), 1000)
        {
            public void onTick(long millisUntilFinished){
                textView.setText(String.valueOf(counter));
                counter = counter - 1;
            }
            public  void onFinish(){
                textView.setText("FINISH!!");
                ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
                toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,150);
                isActive = 0;
                sessionsLeft--;
                countDown();
            }
        }.start();
    }
}