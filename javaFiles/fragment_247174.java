public enum State {
    MENU(Menu::new),
    PLAY(Play::new);

    Supplier<AState> stateConstructor;

    State(Supplier<AState> constructor) {
        stateConstructor = constructor;
    }

    public AState createInstance() {
        return stateConstructor.get();
    }
}