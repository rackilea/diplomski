yourButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View view) {
        if(!isButtonAlreadyClicked) {
            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // Do what you need to do
                }
            }
            handler.postDelayed(runnable, 10_000 /* Wait 10 seconds */);
            isButtonAlreadyClicked = true;
        } else {
            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // Stop what you want to stop
                }
            }
            handler.postDelayed(runnable, 2*60*1000 /* Wait 2 minutes */);
            isButtonAlreadyClicked = false;
        }
});