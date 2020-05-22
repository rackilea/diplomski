public DummyTC implements TravelCost {
    private double cost;
    private double duration;

    public DummyTC(double cost, double duration) {
        this.cost = cost;
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public double getCost() {
        return cost;
    }

    // and other methods/properties imposed by TravelCost
}