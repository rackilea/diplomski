class AreodynamicCalculator {
    public static class Builder {
        AircraftConfiguration config;
        Aileron aileronOne;
        Aileron aileronTwo;
        Elevator elevatorOne;
        Elevator elevatorTwo;
        ...

        public Builder config(AircraftConfiguration config) {
            this.config = config;
            return this;
        }

        public Builder addAileron(Aileron aileron) {
            if (this.aileronOne == null) {
                this.aileronOne = aileron;
            } else {
                this.aileronTwo = aileron;
            }
            return this;
        }

        // adders / setters for other fields.

        public AreodynamicCalculator build() {
            return new AreodynamicCalculator(config, aileronOne, aileronTwo ... );
        }
    }

    // this is the AircraftConfiguration constructor, it's now private because
    // the way to create AircraftConfiguration objects is via the builder
    //
    private AircraftConfiguration config, AileronOne aOne, AileronTwo aTwo, ElevatorOne eOne, ElevatorTwo eTwo, Rudder r, Rudder rr, RateGyros rG) {
        /// assign fields
    }
}