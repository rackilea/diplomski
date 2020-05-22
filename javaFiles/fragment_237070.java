class StartSpanSecuritiesState implements RobState {

    private RobEvent robEvent;

    public StartSpanSecuritiesState(RobEvent robEvent) {
        this.robEvent = robEvent;
    }

    @Override
    public void handle() {
        // span your securities
        //...

        // go to the next state
        robEvent.setRobState(new AllSecuritiesSpanedState(robEvent));
    }
}