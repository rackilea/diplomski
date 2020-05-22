Random rand = new Random();
String str = "img_" + rand.nextInt(3);
image = (ImageView) findViewById(R.id.imageView);
image.setTag(str);
int resId = getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()));
image.setImageDrawable(resId);