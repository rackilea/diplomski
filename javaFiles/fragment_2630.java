public enum State {

    ACTIVE("active"), INACTIVE("inactive");

    private String stateName;

    private State(String stateName) {
        this.stateName = stateName;
    }

    public State forStateName(String stateName) {
        for(State state : State.values()) {
            if (state.stateName().equals(stateName)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown state name " + stateName);
    }

    public String stateName() {
        return stateName;
    }
}