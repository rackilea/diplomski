private final AtomicBoolean isOn = new AtomicBoolean(false);
...

// if it is set to false then set it to true, no synchronization needed
if (isOn.compareAndSet(false, true)) {
    statusMessage = "I'm now on";
} else {
    // it was already on
    statusMessage = "I'm already on";
}