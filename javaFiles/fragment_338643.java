// have your 3 channel grayscales and 1 alpha bitmap loaded by this point

Paint redPaint = new Paint();
redPaint.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
redPaint.setShader(new BitmapShader(redChanImg, TileMode.CLAMP, TileMode.CLAMP));
redPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, Mode.DARKEN));

Paint greenPaint = new Paint();
greenPaint.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
greenPaint.setShader(new BitmapShader(greenChanImg, TileMode.CLAMP, TileMode.CLAMP));
greenPaint.setColorFilter(new PorterDuffColorFilter(Color.GREEN, Mode.DARKEN));

Paint bluePaint = new Paint();
bluePaint.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
bluePaint.setShader(new BitmapShader(blueChanImg, TileMode.CLAMP, TileMode.CLAMP));
bluePaint.setColorFilter(new PorterDuffColorFilter(Color.BLUE, Mode.DARKEN));

Paint alphaPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
alphaPaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));

c.setBitmap(resultImage);
c.drawRect(0, 0, width, height, redPaint);
c.drawRect(0, 0, width, height, greenPaint);
c.drawRect(0, 0, width, height, bluePaint);
c.drawBitmap(alphaImg, 0, 0, alphaPaint);

//save off resultImage, display it, etc...