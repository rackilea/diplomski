public abstract class AbstractBase<T> {

    private final T genericTypeObject;

    protected Base(Class<T> type){
        try {
            genericTypeObject = type.newInstance();
        } catch (InstantiationException e) {
            // Handle
        } catch (IllegalAccessException e) {
            // Handle
        }
    }
}