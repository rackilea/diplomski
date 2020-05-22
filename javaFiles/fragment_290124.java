public interface Stream<T extends InputStream> {
    public void read(T in);
}

public class StreamReader implements Stream<ByteArrayInputStream> {

    @Override public void read(ByteArrayInputStream in) {
        ...
    }
}