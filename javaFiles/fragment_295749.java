nextButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        radioServiceBinder.nextStation();
    }
});

prevButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        radioServiceBinder.prevStation();
    }
});