final Button buttonAddImage = (Button) findViewById(R.id.buttonAddPicture);
        final Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setEnabled(false);
        buttonAddImage.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            buttonLoadImage.setEnabled(true);
            Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            // Start the Intent
            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);

        }

    });