@Override
    public boolean onTouch(View v, MotionEvent event) {

        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN)
        {
            GeoPoint pGoal = mapView.getProjection().fromPixels(
                    (int) event.getX(),
                    (int) event.getY());

            DisplayInfoMessage("The screen has been touched!" + event.getX() + " AND " + event.getY() + "Latitude: "+ pGoal.getLatitudeE6());   // only for displaying test popup

        }
        super.onTouchEvent(event);

        return true;        

    }