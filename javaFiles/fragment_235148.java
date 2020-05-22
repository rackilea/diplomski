Location currentLocation;
public void updateDistance(Location location){
    if(location.equals(currentLocation)) return;
    //calculate the distance and create the distance string, and set it 
    //as a class field (you can call it mFormattedDistanceString)
    currentLocation = location;
}