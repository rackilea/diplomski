public class Screen {
    private String currentScreen = "Page";
    private boolean isLoaded = false;
    private MobileDriver driver;

    public Screen(MobileDriver mobileDriver) {
        this.driver = mobileDriver;
    }

public String getCurrentScreen() {
    return name;
}

public void setCurrentScreen(String name) {
    this.name = name;
}


public boolean isLoaded() {
    return isLoaded;
}

public void setLoaded(boolean loaded) {
    isLoaded = loaded;
}