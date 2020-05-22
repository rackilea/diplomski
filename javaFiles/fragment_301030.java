public void handleMessage(Object payload) {
    if (payload instanceof Foo) {
        this.fooListener.handleMessage((Foo) payload);
    }
    else if (payload instanceof Bar) {
        this.barListener.handleMessage((Bar) payload);
    }
    else {
        // unexpected payload type
    }
}