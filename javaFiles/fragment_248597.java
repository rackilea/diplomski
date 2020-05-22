class MyBinder extends AbstractBinder {

    private final MyState stateful;

    public MyBinder (MyState stateful) {
        this.stateful = stateful;
    }

    @Override
    protected void configure() {
        bind(stateful).to(MyState.class);
    }
}