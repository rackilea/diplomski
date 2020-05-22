public abstract class CustomAdapter<T extends Object> {
    public abstract Boolean addItem(T aObject);
}

public class RainAdapter extends CustomAdapter<Rain> {
    @Override
    public Boolean addItem(Rain aRainInfo) {
        // do something
        return true;
    }
}