Button button = getYourButton();
button.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        new WhatsNewScreen(someActivityContext).show(false);
        // or show(true) if you want a version check 
        // If you are calling it from your MainActivity you can write MainActivity.this
        // instead of someActivityContext. 
    }
});