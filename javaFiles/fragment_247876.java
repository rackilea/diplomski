for(Object intObj : page.content) {
    ImageView imageView = new ImageView(this.getContext());
    Drawable myDrawable = getResources().getDrawable((int) intObj);
    imageView.setImageDrawable(myDrawable);
    //Changing height...
    imageView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
    //...and width
    imageView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
    scrollViewLayout.addView(imageView);
}