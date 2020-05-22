public class LocationInfo {

  private String locationId;
  private String locationName;

  @JsonUnwrapped
  private State state;
}