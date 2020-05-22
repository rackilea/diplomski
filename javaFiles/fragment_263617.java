public class LocationModel implements Comparable<LocationModel> {
  ...
  @Override
    public int compareTo(LocationModel other) {
        return this.locName.compareToIgnoreCase(other.getLocName());
    }
}