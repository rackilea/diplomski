Bin2Zipper.add(is1, name1).add(is2, name2).add(is3, name3).toZip(os);

public final class Bin2Zipper {

    private final List<InputStream> inputStreams = ...;
    private final List<String> names = ...;

    private Bin2Zipper(final InputStream is, final String name) {
         this.inputStreams.add(is);
         this.names.add(name);
    }

    public static Bin2Zipper add(final InputStream is, final String name) {
         return new Bin2Zipper(is, name);
    }

    public Bin2Zipper add(final InputStream is, final String name) {
         this.inputStreams.add(is);
         this.names.add(name);
         return this;
    }

    public void zip(final OutputStream os) {
        ...
    }
}