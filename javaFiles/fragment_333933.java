class TCPConnection {
    ...
    boolean isEstablished() {
        return this.getState().isEstablished();
    }
}