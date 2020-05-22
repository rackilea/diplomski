private boolean newTouch = false;
private int oldProgress;
@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
if (fromUser) {
    if (newTouch) {
        oldProgress = progress;
        priceView.setText("About how much will it cost? $" + String.valueOf(progress));
        if(progress == seekBar.getMax()) {
            newTouch = false;
            switch (progress) {
                case 100:
                    seekBar.setMax(250);
                    seekBar.setProgress(100);  
                    maxPriceView.setText("$" + String.valueOf(seekBar.getMax()));
                    break;
                case 250:
                    seekBar.setMax(500);
                    seekBar.setProgress(250);
                    maxPriceView.setText("$" + String.valueOf(seekBar.getMax()));
                    break;
                case 500:
                    seekBar.setProgress(250);
                    maxPriceView.setText("$500+");
                    break;
            }
        }
    } else {
        seekBar.setProgress(oldProgress);
    }
}
}

@Override
public void onStartTrackingTouch(SeekBar seekBar) {
    newTouch = true;
}