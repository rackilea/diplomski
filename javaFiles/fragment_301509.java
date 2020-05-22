InputStream stdin = System.in;

// Create a wrapper (with it's own dedicated read-thread)
MyListenableInputStream listenableInputStream =
        new MyListenableInputStream(stdin);

// Update System.in with something more useful.
System.setIn(listenableInputStream);