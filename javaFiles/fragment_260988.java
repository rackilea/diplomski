public interface Factory {
    public Lookup getLookup();
    public Key getKey();
}

public class Program {
    private Lookup lookup;

    public Program(Factory factory) {
        lookup = factory.getLookup();
    }

    public void printLookup(Factory factory) {      
        System.out.println((lookup.getValue(factory.getKey()));
    }
}