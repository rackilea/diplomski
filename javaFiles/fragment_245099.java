class SomeWeirdConfig {
    void makeSomeWeirdConfigs() { ... }
}

SomeWeirdConfig delegate = new SomeWeirdConfig();

public void initTest() { delegate = null; }

private void makeSomeWeirdConfigs() {
    if (delegate != null) {
        delegate.makeSomeWeirdConfigs();
    }
}