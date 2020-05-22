// circle
int diameter = 500;
Bitmap bm = Bitmap.createBitmap(diameter, diameter, Bitmap.Config.A
Canvas canvas = new Canvas(bm);
Paint p = new Paint();
p.setColor(getResources().getColor(R.color.green));
canvas.drawCircle(diameter / 2, diameter / 2, diameter / 2, p);


// marker icon through Drawable
Drawable drawable = getResources().getDrawable(R.drawable.marker_icon, null);
// you should choose bounds
// drawable.setBounds(left, top, right, bottom);
drawable.draw(canvas);

//OR marker icon through Bitmap
Bitmap bmIcon = BitmapFactory.decodeResource(getResources(), R.drawable.marker_icon);
// choose correct top and left margin
canvas.drawBitmap(bmIcon, diameter / 2, diameter / 2, p);


map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(bm)));