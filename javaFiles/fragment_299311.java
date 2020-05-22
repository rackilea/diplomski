boolean preButtonWasPressed = false;
// snip

// snap
preButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        preButtonWasPressed = true;
    }
});