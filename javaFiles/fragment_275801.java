import javafx.collections.SetChangeListener;

@FunctionalInterface
public interface ErrorLoggingSetChangeListener<E> extends SetChangeListener<E> {


    public void delegate(Change<? extends E> change) throws Exception ;

    @Override
    public default void onChanged(Change<? extends E> change) {
        try {
            delegate(change);
        } catch (Exception exc) {
            // just do a System.out.println here to demo we reach this block:
            System.out.println("Custom error handling...");
            exc.printStackTrace();
        }
    }
}