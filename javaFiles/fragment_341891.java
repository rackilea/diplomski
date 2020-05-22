seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                    boolean fromUser) {

                int MIN = 5;
                if (progress < MIN) {

                    value.setText(" Time Interval (" + seektime + " sec)");
                } else {
                    seektime = progress;
                }
                value.setText(" Time Interval (" + seektime + " sec)");

            }
        });