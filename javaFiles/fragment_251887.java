@FunctionalInterface
public interface Ball
{
    default void hit() {
        hit(true);
    }

    void hit(boolean miss);
}