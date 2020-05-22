@Override
    public void onTick(long millisUntilFinished) {
        // TODO Auto-generated method stub
        long millis = millisUntilFinished;
        String hms = String.format(
                "%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                        .toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                        .toMinutes(millis)));
        System.out.println(hms);
        times.setText(hms);
    }
  @Override
    public void onFinish() {
        times.setText("Time is up");
        Intent resultActivityIntent= new Intent(currentActivityName.this, ResultActivity.class);
        startActivity(resultActivityIntent);
    }