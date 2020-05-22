// declared outside your runnable
final AtomicInteger result = new AtomicInteger(0);

// in your run method
// return value; // doesn't work, can't return
result.set(value);