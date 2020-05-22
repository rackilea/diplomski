seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onProgressChanged(SeekBar p1, int progress, boolean p3)
        { 
            mainTextView.setText(String.valueOf(progress));
            x=progress;
            sum = x + y;
            totalView.setText(String.valueOf(sum));            }
    });

    seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onProgressChanged(SeekBar p1, int progress, boolean p3)
        {
            mainTextView.setText(String.valueOf(progress));
            y=progress;
            sum = x + y;
            totalView.setText(String.valueOf(sum));            }
    });