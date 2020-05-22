// Call a native function in a dedicated java thread
native void cFunction();
...
new Thread() {
    public void run() {
        cFunction();
    }
};