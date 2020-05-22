public void loadLevelScreen (String name) {
    String packageName = getPackage().getName();
    Class<? extends MyScreen> screenClass = null;
    try {
        screenClass = Class.forName(packageName + "." + name).asSubclass(MyScreen.class);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    try {
        MyScreen screen = screenClass.newInstance();
        screen.init(this.game);
        setScreen(screen);
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
}