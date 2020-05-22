Bitmap bitmap = Bitmap.createBitmap(600,400,Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);

            RectF outerRectangle = new RectF(0, 0, 600, 400);
            RectF innerRectangle = new RectF(100, 100, 500, 300);

            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(Color.BLACK);
            paint.setAlpha(80);
            canvas.drawRect(outerRectangle, paint);

            paint.setColor(Color.TRANSPARENT);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            canvas.drawRect(innerRectangle, paint);

            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);
            canvas.drawRect(innerRectangle, paint);

            image1.setImageBitmap(bitmap);