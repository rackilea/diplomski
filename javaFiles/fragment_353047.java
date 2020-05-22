public abstract class BasePage {

    public abstract BasePage load();
}

public class HomePage extends BasePage {

    @Override
    public HomePage load() {
        //...
        return this;
    }
}