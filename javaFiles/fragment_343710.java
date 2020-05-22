Picasso
    .with(getContext())
    .load(profile.getUserImageUrl())
    .into(imageView, new Callback()
    {
        @Override
        public void onSuccess()
        {
            // Update card
        }

        @Override
        public void onError()
        {
            Log.e("App","Failed to load company logo");
        }
    });