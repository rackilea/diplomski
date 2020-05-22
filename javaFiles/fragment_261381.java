Button button = (Button) findViewById(R.id.button1);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        handler.removeCallbacks(runnable);
        // do your Button stuff
        anotherMethod();
    }
});