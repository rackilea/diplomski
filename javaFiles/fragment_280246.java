final Bitmap bitmap = ((BitmapDrawable) getResources()
                .getDrawable(DEFAULT_RESOURCE_LIST[n])).getBitmap();
        return bitmap;
        /*
        Bitmap bitmap = Bitmap.createBitmap(TEXTURE_WIDTH, TEXTURE_HEIGHT,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawARGB(0, 0, 0, 0);
        mPaint.setColor(0x40808080);
        canvas.drawRect(2, 2, TEXTURE_WIDTH-2, TEXTURE_HEIGHT-2, mPaint);
        mPaint.setTextSize(100.0f);
        mPaint.setAntiAlias(true);
        mPaint.setColor(0xffffffff);
        canvas.drawText("" + n, 2, TEXTURE_HEIGHT-10, mPaint);
        canvas.drawBitmap(mGlossyOverlay, null,
                new Rect(PIXEL_BORDER, PIXEL_BORDER,
                        TEXTURE_WIDTH - PIXEL_BORDER, TEXTURE_HEIGHT - PIXEL_BORDER), mPaint);
        return bitmap;
        */
    }