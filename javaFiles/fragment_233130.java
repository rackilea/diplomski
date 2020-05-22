public class BikeBuilder {
    private String model;
    private String wheelSize;
    private String shocks;
    private String racingHandleBarType;

    // returns "this" so you can chain calls, common in builders, not necessary
    public BikeBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    // Other setters

    public Bike build() {
        Bike bike;
        // Determine which kind of bike it is and create it
        if (shocks != null) {
            bike = new MountainBike();
            handleMountainBike((MountainBike) bike);
        } else if (racingHandleBarType != null) {
            bike = new RacingBike();
            handleRacingBike((RacingBike) bike);
        } else {
            bike = new Bike();
        }
        handleCommonAttributes(bike);
        return bike;
    }

    // All bikes have these attributes
    private void handleCommonAttributes(Bike bike) {
        bike.setModel(model);
        bike.setWheelSize(wheelSize);
    }

    private void handleMountainBike(MountainBike bike) {
        bike.setShocks(shocks);
    }

    private void handleRacingBike(RacingBike bike) {
        bike.setRacingHandleBarType(racingHandleBarType);
    }
}