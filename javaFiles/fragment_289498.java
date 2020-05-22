// declear global variable
private final String COORD_BROADCAST_FILTER = "COORD_BROADCAST_FILTER";
private Location newLocation;

private BroadcastReceiver coordinateReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
try {
            newLocation.setLatitude(intent.getDoubleExtra("LOC_LAT", 0.0));
            newLocation.setLongitude(intent.getDoubleExtra("LOC_LON", 0.0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

 };