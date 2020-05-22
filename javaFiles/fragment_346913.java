public View getView(int position, View convertView, ViewGroup parent) {
    ImageView imageView;
    LinearLayout lLayout;
    if (convertView == null) {
        // if it's not recycled, initialize some attributes
    lLayout=new LinearLayout(context);
    lLayout.setLayoutParams(new LinearLayout.LayoutParams   (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    lLayout.setGravity(Gravity.CENTER);

        imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(8, 8, 8, 8);

    lLayout.addView(imageView);
    } else {
        lLayout= (LinearLayout) convertView;
    }


  ((ImageView)lLayout.getChildAt(0)).setImageResource(R.drawable.card_back);

    return lLayout;
}