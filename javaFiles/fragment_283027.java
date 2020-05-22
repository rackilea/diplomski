a = (ImageView) findViewById(R.id.imageView3);
pengesat = new TranslateAnimation( 0.0f,  300.0f,  0.0f,  0.0f );
pengesat.setDuration(5000);
pengesat.setRepeatCount(2);
pengesat.setInterpolator(new LinearInterpolator());
a.setAnimation(pengesat); //<-- this line here is new