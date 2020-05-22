@Override
public void onProgressChanged(SeekBar seekBar, int progress,
        boolean fromUser) {


    switch (seekBar.getId()) {
    case R.id.redSeekBar:
        redValue = redSeekBar.getProgress();
        break;
    case R.id.greenSeekBar:
        greenValue = greenSeekBar.getProgress();
        break;
    case R.id.blueSeekBar:
        blueValue = blueSeekBar.getProgress();
        break;
    case R.id.alphaSeekBar:
        alphaValue = alphaSeekBar.getProgress();
        break;
    }

    colorValue = argb(alphaValue, redValue, greenValue, blueValue);

    colorView.setBackgroundColor(colorValue);

    output = "Red: " + redValue + " Green: " + greenValue + " Blue: "
            + blueValue + " Alpha: " + alphaValue;

    colorTextView.setText(output);
}