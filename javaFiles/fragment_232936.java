String imageUrl = PHP_MYSQL_SITE_URL + "images/thumb/" + imageUrl;
ImageView im = findViewById(R.id.imageView2);
Picasso.get().load(imageUrl).into(new Target() {

                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom arg1) {
                            im.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onBitmapFailed() {

                    }
                });