for(Location location : locations){
    int distance = Location.distanceBetween(closestLocation.getLatitude(),
                           closestLocation.getLongitude(),
                           location.getLatitude(),
                           location.getLongitude());
    if(smallestDistance == -1 || distance < smallestDistance){
        closestLocation = location;
        smallestDistance = distance;
    }
}