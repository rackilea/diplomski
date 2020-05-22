SeekBar seekBar = (SeekBar) findViewById(R.id.seekBarDistance);
    final TextView seekBarValue = (TextView) findViewById(R.id.seekBarDistanceValue);

    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
            boolean fromUser) {
        // TODO Auto-generated method stub 
            seekBarValue.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub 
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub 
        }

    });