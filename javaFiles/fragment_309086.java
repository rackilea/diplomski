abstract class Vehicle {
    public abstract void accept(AddToListVisitor visitor);
}

class Car extends Vehicle {
    public void accept(AddToListVisitor visitor) {
        //gets handled in this class
    }
}