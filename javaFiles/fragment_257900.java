public class Location // an ADT
{
    private double longitude, latitude;

    public Location(double lg, double lt) {
        longitude = lg;
        latitude = lt;
    }

    public void show() {
        System.out.println(longitude + " " + latitude);
    }

    public Location plus(Location op2) {
        Location temp = new Location(0.0, 0.0);
        temp.longitude = op2.longitude + this.longitude;
        temp.latitude = op2.latitude + this.latitude;
        return temp;
    }
}