private void RotateMap()
{
     mRotateView = new RotateView(this);

     mRotateView.addView(mapView);   //   if i use this 2 lines, the activity start with the map rotation
     setContentView(mRotateView); 

}