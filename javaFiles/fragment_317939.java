ArrayList<ImageView> imageViews= new ArrayList<ImageView>();

        for (int i = 0; i < 50; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(R.drawable.yourimage);
            imageViews.add(imageView);
        }