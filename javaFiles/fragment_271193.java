ImageView imageView = new ImageView(this);
imageView.setImageBitmap(bmp);
imageView.setLayoutParams(params);
imageView.setBackgroundResource(R.drawable.main_header_selector);
imageView.setPadding(2, 2, 2, 2);
imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // <- set the scale
imageView.setCropToPadding(true); // <- requires API 16 or more