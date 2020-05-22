// Create an anonymous implementation of OnClickListener
private OnClickListener myClickListener = new OnClickListener() {
    public void onClick(View v) {
        // increment the counter on click
        numberOfClicks++;
    }
};