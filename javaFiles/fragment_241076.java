public class Stations {
    // Use an AtomicReference to make sure that all threads see the last instance
    private static final AtomicReference<Stations> INSTANCE = 
        new AtomicReference<>(new Stations());
    private List<Station> stations;

    public Stations() {
    }

    public Stations(final List<Station> stations) {
        // Make a safe and unmodifiable copy of the list of stations
        this.stations = Collections.unmodifiableList(new ArrayList<>(stations));
    }

    public static Stations getInstance() {
        return INSTANCE.get();
    }

    public List<Station> getStations(){
        return this.stations;
    }

    public static void setInstance(Stations stations) {
        // Set the new instance
        INSTANCE.set(new Stations(stations.getStations()));
    }
}