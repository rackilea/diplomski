myImageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myImageView.setImageBitmap(RotateBitmap(((BitmapDrawable)myImageView.getDrawable()).getBitmap() , 90));
        }
    });