for (int i = MainActivity.LEFT_IMAGE; i <= MainActivity.RIGHT_IMAGE; i++) {
    _filterImageView[i] = _originalBitmaps[i].copy(_originalBitmaps[i].getConfig(), true);
} 
    Button filter6Button = (Button) findViewById(R.id.filter6_button);
    filter6Button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            for (int i = MainActivity.LEFT_IMAGE; i <= MainActivity.RIGHT_IMAGE; i++) {

                _filterImageView[i] = _BrightnessIncrease
                        .filterImage(_filterImageView[i]);
                // */
            }
            _filterImageView
                    .setImageBitmap(_filterImageView[MainActivity.LEFT_IMAGE]);
        }
    });