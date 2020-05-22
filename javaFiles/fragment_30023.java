new CountDownTimer(90000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            String text = String.format(Locale.getDefault(), "Time Remaining %02d min: %02d sec", 
            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60, 
            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
            tvTime.setText(text);
        }
 });