public synchronized void initHelper() {
    Object result = Object.new();
    result.<init>();
    // result is now fully initialized
    // but helper is still null for all threads
    this.helper = result;
    // now all threads can access fully initialized helper
}