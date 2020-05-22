public class SerializableSingleton implements Serializable {
    public static final SerializableSingleton INSTANCE = new SerializableSingleton();
    private static final long serialVersionUID = 1L;
    int value;
    private SerializableSingleton() {
        System.out.println("SerializableSingleton initialized");
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    protected Object readResolve() {
        System.out.println("replacing "+this+" with "+INSTANCE);
        return INSTANCE;
    }
    public String toString() {
        return "SerializableSingleton{" + "value=" + value + '}';
    }
}