public abstract class AbstractTestLoader<T extends AbstractEntity<T>> {

    abstract Class<T> getEntityType();

    public void onMessage(TextMessage message) throws Exception {
        onMessage(message, getEntityType());
    }

    public void onMessage(TextMessage message, Class<T> clazz) throws Exception {
        //here my original logic will go
    }
}