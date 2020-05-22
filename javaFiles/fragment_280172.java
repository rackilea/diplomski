public class Consumption {

    private double miles = 0;
    private double gallons = 0;
    private double mpg = 0;
    private int numberOfTrips = 0;

    public void addTrip(double miles, double gallons) throws IllegalArgumentException {
        if (miles > 0 && gallons > 0) {
            this.miles += miles;
            this.gallons += gallons;
            numberOfTrips++;
            mpg = this.miles / this.gallons;
        } else {
            throw new IllegalArgumentException("Both miles and gallons have to be greater than zero");
        }
    }

    public double getMiles() {
        return miles;
    }

    public double getGallons() {
        return gallons;
    }

    public double getMpg() {
        return mpg;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

}