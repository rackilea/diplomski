public synchronized void initHelper() {
    this.helper = Object.new();
    // from now on other threads can access helper
    this.helper.<init>();
    // but it's fully initialized only after this line
}