public class GlyCounter extends Structure {
    public class ByReference extends GlyCounter implements Structure.ByReference {};
    // More definition here...
}
public class GlyCounters extends Structure{
    public int ulArraySize;
    public GlyCounter.ByReference lpCounters;

    public GlyCounters(Pointer p) {
        super(p);
        read();
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(new String[] { "ulArraySize", "lpCounters"});
    }
}

// To obtain the full array (assuming they're allocated as a block)
GlyCounters gc = new GlyCounters(pointer);
GlyCounter[] counters = gc.lpCounters.toArray(gc.ulArraySize());