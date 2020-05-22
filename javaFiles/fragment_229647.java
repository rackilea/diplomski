/**
 * JSON-B visibility strategy for deserialization.
 * 
 * Enables JSON binding of private fields without a setter.
 */
public class JsonDeserializationStrategy implements PropertyVisibilityStrategy {

    @Override
    public boolean isVisible(Field field) {
        return true;
    }

    @Override
    public boolean isVisible(Method method) {
        return true;
    }
}