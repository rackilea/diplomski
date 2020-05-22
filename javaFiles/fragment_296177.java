public void addVehicle()
{
    Vehicle vehicle = new Vehicle(base, "Vehicle #" + nextID); // BAD! Calling with 2 Strings
    taxiFleet.add(vehicle);
    // Increment the ID for the next one.
    nextID++;
}