change.setOnClickListener(new Button.OnClickListener() { 
    public void onClick(final View v) {
        v.setBackgroundResource(R.drawable.button_orange);
        Handler handle = new Handler(); // Probably shouldn't create one each time, but here is the idea
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setBackgroundResource(R.drawable.button_green);
            }
        }, 5000);
    } 
});