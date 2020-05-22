ImageView   ivUIL = (ImageView) findViewById(R.id.ivUIL);

 String url = "http://innovativedevicesapps.me/Images/big banner.jpg";


 ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
    ImageLoader.getInstance().init(config);
    ImageLoader.getInstance().displayImage(GlobleArray.array.get(position).getStrUrl(), ivUIL);