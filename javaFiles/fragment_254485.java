private Boolean exit = false;
    private long timeStamp = 0;
    private Handler handler = new Handler();
    @Override
    // Detect when the back button is pressed
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        }
        else {
            if (exit) {
                exit = false; //added
                this.finish();
            }
            else {

                //added:
                if (timeStamp == 0 || (System.currentTimeMillis() - timeStamp) > 3000) {
                    Toast.makeText(this, "Press again to exit.",
                        Toast.LENGTH_SHORT).show();
                    exit = true;

                    timeStamp = System.currentTimeMillis(); //added

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            exit = false;
                        }
                    }, 3 * 1000);
                }
            }

        }
    }