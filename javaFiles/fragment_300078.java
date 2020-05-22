public final class Bin2Zipper {
    private final List<InputStream> inputStreams = ...;
    private final List<String> names = ...;    

    public BinZipper() {
    }

    public void add(final InputStream is, final String name) {
        this.inputStreams.add(is);
        this.names.add(name);
    }

    public void bin2zip(final OutputStream os) {
        // ...
    }
}