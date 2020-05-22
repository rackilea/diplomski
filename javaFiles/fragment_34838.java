public abstract class
GuiComponent<O extends GuiComponent<O, T>, T extends NativeGuiComponent> {
    public <EV extends ComponentEvent> O onEvent(
                                         EventListener<EV,O> listener, Class<EV> clazz) {
        return onEvent(listener, clazz, Side.CLIENT);
    }
    // etc
}