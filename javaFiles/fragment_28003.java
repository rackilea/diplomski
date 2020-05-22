public class CreateVehicle {
    public static void main(String[] args) {

        Car CarObject = new Car();
        Truck TruckObject = new Truck();

        //CarObject.getColor();
        CarObject.setColor();
        //  CarObject.getNoOfCylinders();
        CarObject.setNoOfCylinders();
        //CarObject.toString();
        CarObject.setNoOfSeats();

        //TruckObject.getColor();
        TruckObject.setColor();
        //TruckObject.getNoOfCylinders();
        TruckObject.setNoOfCylinders();
        //TruckObject.toString();
        TruckObject.setTowingCapacity();

        System.out.print(("\nThe car ") + CarObject.toString());
        System.out.print(("\nThe truck ") + TruckObject.toString());
    }
}

    class Car extends Vehicle {
        public String toString() {
            String information;
            information = super.toString() + " and " + noOfSeats + " seats";
            return information;
        }
    }

    class Truck extends Vehicle {
        public String toString() {
            String information;
            information = super.toString() + " and has a towing capacity of " + 
            towingCapacity;
            return information;
        }
    }