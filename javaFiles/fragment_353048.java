public abstract class BasePage <T extends BasePage<T>> {

    public abstract T load();
    public abstract void copyFrom(T another);
}

public class HomePage extends BasePage<HomePage> {

    @Override
    public HomePage load() {
        //...
        return this;
    }

    @Override
    public void copyFrom(HomePage another) {
        //...
    }
}