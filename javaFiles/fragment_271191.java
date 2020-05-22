android.os.Handler mHandler = new Handler();

Runnable rUpdateTextView = new Runnable() {
    @Override
    public void run () {
        yourTextView.setText(returndate());
        // Update your TextView every 200ms
        mHandler.postDelayed(this, 200);
    }
};

@Override
protected void onCreate(Bundle savedInstanceState) {
    [...]
    mHandler.post(rUpdateTextView);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mHandler.removeCallbacks(rUpdateTextView);
         }
    });
}