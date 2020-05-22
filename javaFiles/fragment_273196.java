interface IReceiver {
    void receive(Object o);
}
class MyReceiver implements IReceiver {
    @Override
    public void receive(Object o) {
        // TODO Auto-generated method stub
    }
}
enum Receivers {
    // anonymous
    FIRST(
        new IReceiver() {
            @Override
            public void receive(Object o) {};
        }
    ), 
    // concrete
    SECOND(new MyReceiver());

    IReceiver receiver;

    Receivers(IReceiver receiver) {
        this.receiver = receiver;
    }

    public IReceiver getReceiver() {
        return receiver;
    }
}