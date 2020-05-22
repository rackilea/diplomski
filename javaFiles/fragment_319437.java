Bitmap bmp3 = BitmapFactory.decodeResource(
        getResources(), R.drawable.maps_position_marker); 
Canvas canvas= new Canvas();

mapView.getProjection().toPixels(p3, screenP3ts);
canvas.drawBitmap(bmp3, screenP3ts.x-15, screenP3ts.y-30, null);