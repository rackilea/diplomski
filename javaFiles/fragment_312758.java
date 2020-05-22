public class Station {
    private static List<Station> sStationArray = null;

    /**
     * Construct a Station from a specially-encoded String. The String
     * must have all the necessary values for the Station, separated by tabs.
     */ 
    public Station(String fieldString) {
        String[] fields = fieldString.split("[\t ]");

        // For safety, setValuesFromArray() should be declared 'final'.
        // Better yet, you could just move its body into this constructor.
        setValuesFromArray(fields);

        // I'm assuming 'mName' is the name field for the Station
        Log.i("Station", this.mName);
    }

    public static Station getStationArray(Context ctx) {
        if (sStationArray == null) {

            // (Please don't use the prefix 'm' for non-member variables!)
            final String[] tempArray = 
                ctx.getResources().getStringArray(R.array.stations);
            final int len = tempArray.length;

            // Passing the length into the ArrayList constructor (if it's
            // known, or can be guessed at) can be a very simple yet
            // effective optimization. In this case the performance boost
            // will almost certainly **not** be meaningful, but it's
            // helpful to be aware of it.
            sStationArray = new ArrayList<Station>(len);    

            for (int i = 0; i < len; i++) {
                Station s = new Station(tempArray[i]);
                sStationArray.add(s);
            }
        }
        return sStationArray;
    }
}