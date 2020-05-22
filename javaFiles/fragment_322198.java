public void enableWs() {
    if (_input instanceof MultiChannelTokenStream) {
        ((MultiChannelTokenStream) _input).enable(HIDDEN);
    }
}

public void disableWs() {
    if (_input instanceof MultiChannelTokenStream) {
        ((MultiChannelTokenStream) _input).disable(HIDDEN);
    }
}