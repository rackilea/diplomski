mSwitch.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (mSwitch.getText().equals("Everybody")) {
            PRIVACY = "E" + PRIVACY.substring(1);
            Log.d("TEXT", PRIVACY);
        } else if (mSwitch.getText().equals("Nobody")) {
            PRIVACY = "N" + PRIVACY.substring(1);
            Log.d("TEXT", PRIVACY);
        }
    }
});