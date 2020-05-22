interface Result {
    void notify(NetworkListener listener);
}

class XMLResult implements Result {

    @Override
    public void notify(NetworkListener listener) {
        listener.onSuccess(this);
    }

}

class JSONResult implements Result {

    @Override
    public void notify(NetworkListener listener) {
        listener.onSuccess(this);
    }
}