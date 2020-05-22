@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.your_layout);

    TextView tv_countdown = (TextView) findViewById(R.id.your_textview_id);

    Calendar start_calendar = Calendar.getInstance();
    Calendar end_calendar = Calendar.getInstance();

    long start_millis = start_calendar.getTimeInMillis(); //get the start time in milliseconds
    long end_millis = end_calendar.getTimeInMillis(); //get the end time in milliseconds
    long total_millis = (end_millis - start_millis); //total time in milliseconds
    end_calendar.set(2015, 10, 6); // 10 = November, month start at 0 = January

    //1000 = 1 second interval
    CountDownTimer cdt = new CountDownTimer(total_millis, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
            millisUntilFinished -= TimeUnit.DAYS.toMillis(days);

            long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
            millisUntilFinished -= TimeUnit.HOURS.toMillis(hours);

            long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
            millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes);

            long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);

            tv_countdown.setText(days + ":" + hours + ":" + minutes + ":" + seconds); //You can compute the millisUntilFinished on hours/minutes/seconds
        }

        @Override
        public void onFinish() {
            tv_countdown.setText("Finish!");
        }
    };
    cdt.start();
}