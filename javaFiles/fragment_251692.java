SignalHandler handler = new SignalHandler () {
    public void handle(Signal sig) {
        ... // handle SIGINT
    }
};
Signal.handle(new Signal("INT"), handler);