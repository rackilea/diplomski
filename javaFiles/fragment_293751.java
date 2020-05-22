your_seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {               

            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                progressChanged = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(your_activity.this,"seek bar progress:"+progressChanged, 
                        Toast.LENGTH_SHORT).show();
            }
        });