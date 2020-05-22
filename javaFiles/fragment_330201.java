public class BikeWarehouse {

    public Bicycle buildBicycle(int speed) {
        Bicycle bicycle = new Bicycle(speed);
        System.out.println("A Bicycle has been created.");
        return bicycle;
    }

    public MountainBike buildMountainBike(int seatHeight, int speed) {
        MountainBike mountainBike = new MountainBike(seatHeight, speed);
        System.out.println("A MountainBike has been created.");
        return mountainBike;
    }
}