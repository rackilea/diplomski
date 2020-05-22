public static class P4_Icel_Murad_Car {
    private int myStartMiles;
    private int myEndMiles;
    private double myGallonsUsed;

    public P4_Icel_Murad_Car(final int odometerReading) { // Constructor does not have return type, do not put int before constructor name
        this.myStartMiles = odometerReading;
        this.myEndMiles = odometerReading; // init end miles with start miles from the start
        this.myGallonsUsed = 0;
    }

    public void fillUp(final int odometerReading, final double gallons) {
        this.myEndMiles = odometerReading; // store current odometer
        this.myGallonsUsed += gallons; // sum up gas
    }

    public double calculateMPG() { // calculate mileage, divide by gallons
        return (this.myEndMiles - this.myStartMiles) / this.myGallonsUsed;
    }

    public void resetMPG() { // reset means start from current odometer reading
        this.myStartMiles = this.myEndMiles;
        this.myGallonsUsed = 0;
    }
}