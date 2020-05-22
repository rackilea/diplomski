@Root(name = "Vehicles")
public class Vehicles
{
    // Maps the list of vehicles
    @ElementList(name = "Vehicles", inline = true)
    private List<Vehicle> vehicles;
}