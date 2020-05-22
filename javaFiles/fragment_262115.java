public class Airline 
{
    private String airlineName;                // Name of the company
    private ArrayList <PlaneStore> planeStore;

    public Airline(String airlineName)
    {
        this.airlineName = airlineName;
        map = new ArrayList<PlaneStore>();
    }
    public void add(PlaneStore plane){ planeStore.add(plane);}


    public void printPlane()
    {

        System.out.println(airlineName);
        System.out.println("\n********Flight List********");
        for (PlaneStore plane: planeStore)
        {
            System.out.println(plane.toString());
        }

    }