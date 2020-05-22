Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
Canvas c = new Canvas(b);
Paint p = new Paint();
p.setColor(Color.GRAY);
p.setStyle(Paint.Style.FILL);
c.drawRect(0, 0, width, height, p);