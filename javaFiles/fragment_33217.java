Signal.handle(new Signal("HUP"), new SignalHandler() {
    public void handle(Signal signal)
    {
        reloadConfiguration();
    }
});