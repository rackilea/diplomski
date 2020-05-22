public class SerializableSingleton implements Serializable {
    public static final SerializableSingleton INSTANCE = new SerializableSingleton();
    private static final long serialVersionUID = 1L;

    private SerializableSingleton() {
        System.out.println("SerializableSingleton initialized");
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}