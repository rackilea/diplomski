@Override
public void onLocationChanged(Location location) {
    longitude = location.getLongitude();
    latitude = location.getLatitude();
    Log.i("", "Latitude: " + latitude);
    Log.i("", "Longitude: " + longitude);
    if(activities != null) {
        for (Activity activity : activities) {
            Location newLocation = new Location(provider);
            newLocation.setLongitude(activity.getLongitude());
            newLocation.setLatitude(activity.getLatitude());

            if(location.distanceTo(newLocation) > 15 && activity.isInProximity()) {
                activity.setInProximity(false);
                stopTimer(activity.getId());
            }
            else if (location.distanceTo(newLocation) <= 15 && !activity.isInProximity()) {
                activity.setInProximity(true);
                startTimer(activity.getId());
            }
        }
    }
}