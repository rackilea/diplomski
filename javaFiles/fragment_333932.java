interface TCPState {
    ...
    boolean isEstablished();
}

class TCPEstablished implements TCPState {
    ...
    boolean isEstablished() {
        return true;
    }
}

class TCPClosed implements TCPState {
    ...
    boolean isEstablished() {
        return false;
    }
}