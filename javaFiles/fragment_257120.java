public interface Operation {
    // This bit isn't very relevant
    int operate(int a, int b);
}

public abstract class AbstractOperation<T extends AbstractOperation<T>> {
    // Lets assume we might need to copy operations for some reason
    public T copy() {
        // Some clever logic that you don't want to copy and paste everywhere
    }
}