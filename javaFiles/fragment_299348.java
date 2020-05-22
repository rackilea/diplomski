class Test{
    public static void main(String[] args) {
        // Create one basic vehicle
        Vehicle a = new Vehicle();
        // And one more advanced
        VehicleWithSteering b = new VehicleWithSteering();

        // A novice driver is satisfied with having a basic vehicle
        NoviceDriver x = new NoviceDriver(a);

        // The advanced driver however needs more functionality
        AdvancedDriver y = new AdvancedDriver(b);

        // A novice driver can use the advanced vehicle as well
        // But he will not bother about the advanced functionality
        NoviceDriver z = new NoviceDriver(b);
    }
}