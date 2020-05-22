interface RobState {
    void handle();
}

class RobEvent extends Looper implements RobState {

    // add new member
    private RobState robState;
    private Shop shop;

    RobEvent(Shop shop) {
        this.shop = shop;
        this.robState = new StartSpanSecuritiesState();
    }

    // add new setter - gets normally called only by a `State`
    void setRobState(RobState robState) {
        this.robState = robState;
    }

    // ..

}