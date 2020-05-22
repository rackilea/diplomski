public void getMarkers( )
{
    Stop.query(Stop.class, new StackMobQuery().field(new StackMobQueryField("stop")), new StackMobQueryCallback<Stop>() {

        @Override
        public void success(List<Stop> result) {

            runThread(result);
        }

        @Override
        public void failure(StackMobException e) {
            System.out.println("Fail");
        }
    });


}


private void runThread(final List<Stop> stops) {

    new Thread() {
        public void run() {
            int i=0;
            while (i++ < 1) {
                try {
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            for(int j=0;j<stops.size();j++)
                            {
                                LatLng markerPos = new LatLng(stops.get(j).getLatitude(), stops.get(j).getLongitude());
                                System.out.println(markerPos);
                                System.out.println(stops.get(j).getName());
                                System.out.println(j);

                                try {
                                    map.addMarker(new MarkerOptions().title(stops.get(j).getName()).snippet("test").position(markerPos));
                                } catch (Exception e) {
                                    System.err.println(e.getMessage());
                                }

                            }
                        }
                    });
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }.start();
}