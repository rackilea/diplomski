public static int createWindow(Class<?> window) throws InstantiationException, IllegalAccessException {
    Window instance = (Window) window.newInstance();
    factory.add(instance);
    instance.windowId = factory.size() - 1;
    if (window != HomeScreen.class) {
        // instance.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ?
        instance.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                App.createWindow(HomeScreen.class);
            }
        });
    }
    instance.run();
    return factory.size() - 1;
}