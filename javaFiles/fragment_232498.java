LatLng myLatLang = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());

double minval = 1000000000000.0;
int minIndex = 0;

for (int i = 0; i < stationsCoord.size(); i++) {

    double distance = CalculationByDistance(myLatLang,stationsCoord.get(i));

    if (distance < minval) {
      minval = distance;
      minIndex = i;
    }

    Log.i("distance " , String.valueOf(distance));

    System.out.println("min=" +minval+ "index="+minIndex);

}