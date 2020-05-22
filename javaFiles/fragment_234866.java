seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int x = seekBar.getProgress();
        if(fromUser && x != 50 && x > 45 && x < 55) {
            seekBar.setProgress(50);
        }
        ....
    }
});