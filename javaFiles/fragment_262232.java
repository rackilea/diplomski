class Vehicle {
    String tag;
}

class Car extends Vehicle { ... }

class Truck extends Vehicle { ... }

class Tag<T> {
    Class<T> tagType;
    String tagName;
}


List<Vehicle> vehicles = new ArrayList<Vehicle>();

vehicles.add(new Car("tag1"));
vehicles.add(new Truck("tag1"));
vehicles.add(new Car("tag2"));
vehicles.add(new Truck("tag2"));

public <T> List<T> getVehiclesByTag(Tag<T> tag) {
    List<T> result = new ArrayList<>();
    for (Vehicle vehicle : vehicles) {
        if (tag.tagType.isInstance(vehicle) && tag.tagName.equals(vehicle.tag))) {
            result.add(tag.tagType.cast(vehicle));
        }
    }
    return result;
}