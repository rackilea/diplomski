final Button b1 = (Button)findViewById(R.id.Button1);
b1.setOnClickListener(new OnClickListener() {
    int currentSound = 0;
    public void onClick(View v) {
        mSoundManager.playSound(currentSound, 0);
        currentSound++;
        currentSound %= mSoundmanager.getNumberOfSounds();
    }
});