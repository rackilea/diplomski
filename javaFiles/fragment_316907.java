public void getReady(){
    timer = (TextView) findViewById(R.id.timer);
    cTimer= new CountDownTimer(5000, 1000) {

        public void onTick(long millisUntilFinished) {
            timer.setText("" + millisUntilFinished / 1000);

        }

        public void onFinish() {
            Bundle b = GetReady.this.getIntent().getBundleExtra("myData");
            Intent myNextIntent = new Intent(GetReady.this, Exercises.class);
            myNextIntent.putExtra("myDataFromGetReady", b); 
            startActivity(myNextIntent);
        }
    }.start();
}