public class YourClass {
    private Location prevLocation = startingLocation;
    private double distance = 0d;

    private void updateDistance(Location location) {
        double distanceToLast = location.distanceTo(prevLocation);
        // if less than 10 metres, do not record
        if (distanceToLast < 10.00) {
            Log.i("DISTANCE", "Values too close, so not used.");           
        } else
            distance += distanceToLast;
            prevLocation = location;
        }
        tv1.setText("Distance Travelled: " + distance + " metres");
    }
}