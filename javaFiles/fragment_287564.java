for (Business b : businesses) {
   View view = getLayoutInflater().inflate(R.layout.card_item, mLinearLayout, false);

   ImageView mImageView = (ImageView) view.findViewById(R.id.image);

  Picasso.with(getBaseContext())
        .load(b.getPhotoUrl())
        .into(mImageView);

 TextView mTextView = (TextView) view.findViewById(R.id.title);
 mTextView.setText(b.getName());

 mLinearLayout.addView(view);
 }