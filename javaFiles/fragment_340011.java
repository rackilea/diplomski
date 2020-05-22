private void sequenceFunction() {
    //Change Alpha from Fully Visible to Invisible
    final Animation animation = new AlphaAnimation(1, 0);
    //Duration - A Second
    animation.setDuration(1000);
    //Animation Rate
    animation.setInterpolator(new LinearInterpolator());
    animation.setStartOffset(250);
    //Repeat Animation
    int randomValue = r.nextInt();
    // code to add value to array
    animation.setRepeatCount(randomValue);
    randomTextView.setText(String.valueOf(randomValue));

    // Reverse animation at the end so the button will fade back in
    animation.setRepeatMode(Animation.REVERSE);

    //Button 1 Flashes
    final Button btn = (Button) findViewById(R.id.button);
    btn.startAnimation(animation);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            view.clearAnimation();
        }
    });


}