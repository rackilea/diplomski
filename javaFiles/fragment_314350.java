map.addMouseListener( new MouseAdapter() { @Override public void mouseClicked( MouseEvent e ) {

   double x = e.getX() - map.getWidth() / 2, // Mouse X with [0,0] at centre.
          y = e.getY() - map.getHeight() / 2, // Mouse Y with [0,0] at centre.
          // Max Y of projected map, in pixel with [0,0] at centre.
          maxY = map.getMapExtension().getMaxY() *  map.getScaleToShowAll(), 
          sqrt2 = Math.sqrt( 2 ), // Can be optimised away, but let's be faithful.
          R = maxY / sqrt2, // Radius of projection, in pixel.
          theta = Math.asin( y / ( R * sqrt2 ) );
   int    delta_long = -lon0Slider.getValue(); // Longtitude shift from -180 to 180.

          // Find lat long in radius and converts to degree.
   double latInRad  = Math.asin( -( 2 * theta + Math.sin( 2 * theta ) ) / Math.PI ),
          latitude  = Math.toDegrees( latInRad ),
          longInRad = Math.PI * x / ( 2 * R * sqrt2 * Math.cos( theta ) ),
          longitude = Math.toDegrees( longInRad ) + delta_long;

   System.out.println( "Lat: " + latitude + ", Long: " + longitude );
}