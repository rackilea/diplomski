synchronized( monitor ) {
    while( empty ) monitor.wait();

    ... remove element ...
    ... maybe set empty ...
    full = false;
    monitor.notifyAll();
}