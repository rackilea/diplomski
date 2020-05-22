public class Route {

    ....

    @JsonProperty("waypoints")
    @JsonDeserialize(using = WayPointsDeserializer.class)
    private List<WayPoints> wayPointsList;

    .....
}