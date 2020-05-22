myImageView = (ImageView) findViewById(R.id.my_image_view);

Intent intent = getIntent();
if (intent.hasExtra(Intent.EXTRA_TEXT)){
    int image = intent.getIntExtra(Intent.EXTRA_TEXT);
    myImageView.setImageResource(image);
}