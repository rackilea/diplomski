@Override
public void updateSeekBar(final int currentPosInMillis, final int durationInMillis) {
    long progressPercent = calculatePercent(currentPosInMillis, durationInMillis);

    if (progressPercent != previousProgressPercent) {
        seekBar.setMax(durationInMillis);
        seekBar.setProgress(currentPosInMillis);
    }
    previousProgressPercent = progressPercent;
}

private int calculatePercent(int currentPosInMillis, int durationInMillis) {
    if(durationInMillis == 0) {
        return 0;
    }
    return (int) (((float)currentPosInMillis / durationInMillis) * 100);
}