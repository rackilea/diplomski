class DebugListener implements Listener<AbstractEvent> {
    private final String msg;
    public DebugListener(String msg) { this.msg = msg; }
    @Override
    public void process(AbstractEvent event){
        System.out.println(msg);
    }
}