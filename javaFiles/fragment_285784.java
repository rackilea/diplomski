configureBlocking(nativefd, false);
try {
    connectResult = connect0(nativefd, address, port);
    if (connectResult == WOULDBLOCK) {
        waitForConnect(nativefd, timeout);
    }
} finally {
    configureBlocking(nativefd, true);
}