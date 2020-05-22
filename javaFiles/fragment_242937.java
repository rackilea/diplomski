Picasso mPicasso = Picasso.with(this);
            mPicasso.load(imageUrl)
                    .into(image1, new com.squareup.picasso.Callback() {


            @Override
                    public void onSuccess() {
                        Drawable drawable = image1.getDrawable();

                        // ...
                    }

                    @Override
                    public void onError() {
                        // ...
                    }
                });