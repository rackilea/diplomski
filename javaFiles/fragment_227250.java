ImageView mImageView = (ImageView) findViewById(R.id.sound_imageView);
Boolean flag = false;
mImageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(flag) {
                //play sound
                flag = false;
            } else {
                //stop sound
                flag = true;
            } 
        }
    });