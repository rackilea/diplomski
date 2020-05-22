class MySuperClass {
    public final void send() {
        preSend();
        // do the work...
        postSend();
    }

    protected void preSend() {
        // to be overridden in by sub classes
    }

    protected void postSend() {
        // to be overridden in by sub classes
    }

}