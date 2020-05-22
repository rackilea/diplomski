mButtons = new ArrayList<Button>();

mClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //stop flashing all buttons
        for(Button button : mButtons) {
            button.clearAnimation();
        }
        //start animation on this button
        v.startAnimation(mAnimation);
    }
});

Button button1 = (Button)findViewById(R.id.button1);
button1.setOnClickListener(mClickListener);
Button button2 = (Button)findViewById(R.id.button2);
button2.setOnClickListener(mClickListener);
//get as many as buttons

mButtons.add(button1);
mButtons.add(button2);
//add all the buttons to array