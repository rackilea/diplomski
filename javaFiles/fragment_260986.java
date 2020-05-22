public class Program {
    private Lookup lookup = new MapLookup();

    public void printLookup(String key) {
        // I hardcoded lookup to be of type MapLookup, so I can cast:
        System.out.println(((MapLookup)lookup).getValue(key));
    }
}