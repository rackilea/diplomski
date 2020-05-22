public void draw(Canvas canvas, MapView mapView, boolean shadow) {
        if(shadow){
       return;
    }

    super.draw(canvas, mapView, shadow);

    // convert bitmap's bounding box into pixels 
        Point top_left = new Point(); 
        mapView.getProjection().toPixels(topLeft, top_left); 
        Point bottom_right = new Point(); 
        mapView.getProjection().toPixels(bottomRight, bottom_right); 
        // Prepare two rectangles (pixels) 
        Rect src = new Rect( 0,0,bmp.getWidth() - 1, bmp.getHeight() - 1 ); 
        Rect dst = new Rect( top_left.x, top_left.y, bottom_right.x,bottom_right.y ); 

        // draw bitmap 
        canvas.drawBitmap(bmp, src, dst, null); 


}