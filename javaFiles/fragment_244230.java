public OuterClass {
    private AtomicBoolean outerMethodHasBeenCalled = new AtomicBoolean();

    private void outerMethod() {
        if (outerMethodHasBeenCalled.compareAndSet(false, true)) {
            // do stuff
        }
    }
...