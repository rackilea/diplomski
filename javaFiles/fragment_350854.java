public class Flag<T> {}

public interface FlagFactory<T> {
    public Flag<T> newInstance();
}

public class BooleanFlagFactory implements FlagFactory<Boolean> {
    public Flag<Boolean> newInstance() {
        return new Flag<Boolean>();
    }
}
public class StringFlagFactory<T> implements FlagFactory<String> {
    public Flag<String> newInstance() {
        return new Flag<String>();
    }
}

HashMap<String, FlagFactory> factories = new HashMap<String, FlagFactory>();

public void test() {
    factories.put("test", new BooleanFlagFactory());
    factories.put("thing", new StringFlagFactory());

    Flag flag = factories.get("test").newInstance();

}