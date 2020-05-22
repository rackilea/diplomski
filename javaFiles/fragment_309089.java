class Car extends Vehicle {
    public void accept(VehicleVisitor visitor) {
        visitor.visit(this);
    }
}

class Boat extends Vehicle {
    public void accept(VehicleVisitor visitor) {
        visitor.visit(this);
    }
}

class Plane extends Vehicle {
    public void accept(VehicleVisitor visitor) {
        visitor.visit(this);
    }
}