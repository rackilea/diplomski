public class Place{
private String name;
private Location location;
/**
 * @return the name
 */
public String getName() {
    return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
    this.name = name;
}
/**
 * @return the location
 */
public Location getLocation() {
    return location;
}
/**
 * @param location the location to set
 */
public void setLocation(Location location) {
    this.location = location;
}


@Override
public String toString() {
    return "Place: " + name + " Location: " + Arrays.toString(location.getCoordinates());
}
}