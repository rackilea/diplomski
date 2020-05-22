synchronized( monitor ) {
    while( full ) {
        monitor.wait();
    }

    ... add element ...
    ... maybe set full ...
    empty = false;
    monitor.notifyAll();
}