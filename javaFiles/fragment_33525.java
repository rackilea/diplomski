Glide.with(context)
                .load(R.drawable.image)
                .apply(new RequestOptions().override(100,100)/*down sample*/)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        //load the image into image view     
                    }
                });