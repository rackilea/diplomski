AtomicInteger x = new AtomicInteger(0);

eventHandler = new EventHandler(this);
eventHandler.start();
eventHandler.createEvent("Change X Value", 800, new EventHandler.OnEventListener() {
    @Override
    public void onFinished() {
        // x is effectively final so we can reference it
        x.set(5);
    }
});