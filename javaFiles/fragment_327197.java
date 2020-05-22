ScrollView scroll = (ScrollView) findViewById(R.id.yourScrollView);
if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
    scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
        @Override
        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            Log.e(TAG, "SCROLL = " + scrollY);
            if(scrollY > txtView_Y){
                setTitle("Hello");
            }
            else{
                setTitle("I'm not there yet");
            }
        }
    });
}