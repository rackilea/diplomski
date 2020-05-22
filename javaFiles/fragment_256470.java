public class CrossCastUtils {

    private final ObjectOutputStream oos;
    private final ObjectInputStream ois;

    public CrossCastUtils() throws IOException {
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream(pos);
        oos = new ObjectOutputStream(pos);
        ois = new ObjectInputStream(pis);
    }

    public <T> T cast(Object object) throws IOException, ClassNotFoundException {
        oos.writeObject(object);
        oos.flush();
        return (T) ois.readObject();
    }