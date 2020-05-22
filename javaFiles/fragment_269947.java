public interface Factory {
    public <T> List<T> create();
}

public class FactoryImpl implements Factory {
    public <T> ArrayList<T> create() {
        return new ArrayList<T>();
    }
}

...
Factory f = new FactoryImpl();
List<String> strings = f.create();
...