private double tempLong, tempLat; //declare it at class level

@Override
public void locationChanged(double longitude, double latitude) {
    try {
        System.out.println("Longitude: " +longitude);
        System.out.println("Latitude: " + latitude);
        Track f = new Track();
        tempLong = longitude;
        tempLat = latitude;
    } catch (NullPointerException e) {

    }
@Override
 public void ShiftView(Object obj) {
    (Fragment) obj.setMyCoords(tempLat, tempLong);
    //if above line causes error try the line below;
    //Track f = (Fragment) obj;
    //f.setMyCoords(tempLat, tempLong);
    FragmentTransaction ft = getFragmentManager().beginTransaction();
    ft.replace(R.id.activity_main_framelayout, (Fragment) obj); 
    //ft.replace(R.id.activity_main_framelayout, f);
    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    ft.addToBackStack(null);
    ft.commit();
}