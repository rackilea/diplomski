public class Stations {
    // Use an AtomicReference to make sure that all threads see the last list of stations
    private final AtomicReference<List<Station>> stations = new AtomicReference<>();
    private Stations() {
        // Exists only to defeat instantiation.
    }
    public static Stations getInstance() {
        // Lazy create your instance of Stations using a static inner class
        // for thread safety
        return StationsHolder.INSTANCE;
    }
    public List<Station> getStations(){
        // Get the last list of stations from the AtomicReference
        return this.stations.get();
    }

    public void setStations(List<Station> stations) {
        // Set the new list of stations and make it unmodifiable for thread safety
        this.stations.set(Collections.unmodifiableList(stations));
    }

    private static class StationsHolder {
        private static final Stations INSTANCE = new Stations();
    }
}