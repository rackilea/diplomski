@Root(name = "Vehicle")
public class Vehicle
{
    // All values are of type String - please replace with proper types
    @Element(name = "Route")
    private String route;
    @Element(name = "Direction")
    private String direction;
    @Element(name = "Updatetime")
    private String updateTime;
    @Element(name = "Vehicleid")
    private String vehicleID;
    @Element(name = "Block")
    private String block;
    @Element(name = "Adherance")
    private String adherance;
    @Element(name = "Adhchange")
    private String adhchange;
    @Element(name = "Reliable")
    private String reliable;
    @Element(name = "Offroute")
    private String offroute;
    @Element(name = "Stopped")
    private String stopped;
    @Element(name = "Inservice")
    private String inservice;
    @Element(name = "Speed")
    private String speed;
    @Element(name = "Heading")
    private String heading;
    @Element(name = "Routeid")
    private String routeID;
    @ElementList(name = "Positions")
    private List<Position> postions;


    // A class to map the position elements
    @Root(name = "Position")
    public static class Position
    {
        @Text()
        private String position;
    }
}