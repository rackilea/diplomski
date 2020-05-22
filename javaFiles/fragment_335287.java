public synchronized int getSoTimeout() throws SocketException {
    if (isClosed())
        throw new SocketException("Socket is closed");
    Object o = getImpl().getOption(SocketOptions.SO_TIMEOUT);
    /* extra type safety */
    if (o instanceof Integer) {
        return ((Integer) o).intValue();
    } else {
        return 0;
    }
}