public class MoreMatchersTest {
    public interface IMethods {
        String simpleMethod(String argument);
        String simpleMethod(Collection<?> collection);
        String simpleMethod(Object argument);
    }

    private IMethods mock;

    public static <T> T any() {
        return null;
    }

    public static <T> T verify(T m) {
        return m;
    }

    public void any_should_be_actual_alias_to_anyObject() {
        verify(mock).simpleMethod(any());
    }
}