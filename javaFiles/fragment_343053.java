// Declare a global variable of the list of your locations. 
ArrayList<LatLng> arrayLis; 
int i = 0; 

// Just start the first task without the loop. 
double latitude = ((LatLng)arrayLis.get(i)).latitude;
double longitude = ((LatLng)arrayLis.get(i)).longitude;
String url = "https://api.darksky.net/forecast/APIKEY/"
        +latitude+","+longitude+"?units=si";
LatLng mylatlng = new LatLng(latitude,longitude);
startProcess(url,mylatlng);