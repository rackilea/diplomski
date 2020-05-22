public void myTimer() {
    Timer t = new Timer();

    t.schedule(new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run () {
                    if (mMap != null) {

                        x = x + 1;
                        y = y + 1;

                        NextPosition = new LatLng(x, y);

                        marker.setPosition(NextPosition);
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(NextPosition));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(16f));
                    }
                }
            });
        }
    }, 2000, 1000);
}