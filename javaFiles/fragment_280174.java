// create instance of ConsumptionManager somewhere, possibly in your start-up code: 
    // ConsumptionManager mgr=new ConsumptionManager();
    try {
        Consumption consumption=mgr.addTripData(CarType.forId(id), miles, gallons);
        // display mpg/number of trips/etc, e.g. on the console
        System.out.println(String.format("Average range after %d trips: %f", consumption.getNumberOfTrips(),consumption.getMpg()));
    } catch (Exception e) {
        // display error to the user, e.g. on the console
        System.out.println(e.getMessage());
    }