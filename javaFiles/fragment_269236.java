LinearLayout linearLayout = findViewById(R.id.linearLayout);
   ArrayList<Bitmap> listData = new ArrayList<>();

    for (Bitmap a : listData) {
        ImageView image = new ImageView(this);
        image.setLayoutParams(new android.view.ViewGroup.LayoutParams(80, 60));
        image.setMaxHeight(20);
        image.setMaxWidth(20);
        image.setImageBitmap(a);
        linearLayout.addView(image);
      }