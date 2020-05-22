static final class Stats {
    int noOfVehiclesSum;
    double totalTaxSum;
    int count;

    @Override
    public String toString() {
        return "Stats{" + "noOfVehiclesSum=" + noOfVehiclesSum +
               ", averageTax=" + (totalTaxSum / count) + '}';
    }
}