public interface YourInterface {
    ...
    default boolean someMethod () {
        return false;
    }
    ...
}