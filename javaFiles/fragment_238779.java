mask = Bitmap.createBitmap(this.getWidth(),this.getHeight(), 
    Bitmap.Config.ARGB_8888);
    Canvas can = new Canvas(mask);

    Paint clear = new Paint();
    clear.setColor(Color.argb(255,255,0,0));
    can.drawRect(new Rect(0,0,this.getWidth(),this.getHeight()),clear);

    PorterDuffXfermode xfer = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    clear.setXfermode(xfer);
    clear.setColor(Color.TRANSPARENT);
    can.drawCircle(this.getWidth()/2, this.getHeight()/2, this.getHeight()/2, clear);