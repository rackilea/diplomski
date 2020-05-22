private boolean imAwake = false;

@Overwrite
protected void onCreate(Bundle savedInstanceState) {
    new Handler().postDelayed(new Runnable() {

        @Override
        public void run() {
            imAwake = true;
        }
    }, 3000);
}