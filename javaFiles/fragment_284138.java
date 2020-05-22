public class Location {
int id;
double latitude;
double longitude;
LatLng location;

public Location() {}

public Location(int id, double latitude, double longitude) {
    this.id = id;
    this.latitude = latitude;
    this.longitude = longitude;

}

public Location(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
}

public void setId(int id) {
    this.id = id;
}

public void setLatitude(double latitude) {
    this.latitude = latitude;
}

public void setLongitude(double longitude) {
    this.longitude = longitude;
}

public void setLocation(LatLng location) {
    this.location = location;
}

public int getId() {
    return this.id;
}

public double getLatitude() {
    return this.latitude;
}

public double getLongitude() {
    return this.longitude;
}

public LatLng getLocation() {
    return new LatLng(latitude, longitude);
}
}