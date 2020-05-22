public class MainPageController extends FactoryAccessController implements ShutdownObserver {

    // keep reference to listener in case it should be removed
    private final InvalidationListener listener = o -> {
        // write data from fieldGoal to file
    };

    @Override
    public InvalidationListener getObserver() {
        return listener;
    }
}