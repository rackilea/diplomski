public class LinearViewModel extends AbstractViewModel {

    private int currentIndex;

    @Override
    protected int getCurrentViewIndex() {
        return currentIndex;
    }

    @Override
    public void nextView() {
        if (currentIndex + 1 < size()) {
            currentIndex++;
            fireStateChanged();
        }
    }

    @Override
    public void previousView() {
        if (currentIndex - 1 >= 0) {
            currentIndex--;
            fireStateChanged();
        }
    }    
}