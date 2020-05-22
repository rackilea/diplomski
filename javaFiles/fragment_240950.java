class RouteResponse {
    private List<Route> routes;
}
class Route {
    private List<Bound> bounds;
    private String copyrights;
    private List<Leg> legs;
}
class Leg {
    private Distance distance;
    private Duration duration;
    private String endAddress;
    ...
}
class TextValue {
    private String text;
    private String value;
}
class Distance extends TextValue {
}
// And so on