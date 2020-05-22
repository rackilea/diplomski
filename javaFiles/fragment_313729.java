public final class BoatList {

    private static BoatList instance = null;
    private List<Boat> list_of_boats = new ArrayList<Boat>();

    private BoatList()
    {
        // Exists only to defeat additional instantiations.
    }

    public static BoatList getInstance()
    {
        if(instance == null)
            instance = new BoatList();

        return instance;
    }

    public List<Boat> getListOfBoats()
    {
         return list_of_boats;
    }

    public void addBoat(Boat boat)
    {
        list_of_boats.add(boat);
    }
}