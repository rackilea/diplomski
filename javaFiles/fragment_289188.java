public class BusInformation {
    private String id, username,phone;
    private LatLng position;
    private String destination;

    //no-argument constructor
    public BusInformation(){}

    public BusInformation(String id, String username, String phone,  String destination,LatLng position) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.position = position;
        this.destination = destination;
    }
}