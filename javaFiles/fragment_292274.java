public class RecordFactory {
    public Record newInstance(Class<? extends Record> klass, Object... args) {
        Constructor[] ctors = klass.getDeclaredConstructors();
        // find the right constructor here..
        return ctor.newInstance(args);
    }
}