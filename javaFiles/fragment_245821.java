public void goButtonClicked(View v) {
    if(mp == null) {
        mp = MediaPlayer.create(getApplicationContext(), R.raw.wordt);
    }
    ....
}