RelativeLayout relativeLayout = new RelativeLayout(this);

ImageView sprite = (ImageView)findViewById(R.id.sprite);

//Where 80 is the width and 90 the height
RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(80, 90);

// Setting position of our ImageView
//you can use the margins of the layout
layoutParams.leftMargin = 80;
layoutParams.topMargin = 90;
//layoutParams.rightMargin = 80; //Example
//layoutParams.bottomMargin = 90; //Example


relativeLayout.addView(imageView, layoutParams);