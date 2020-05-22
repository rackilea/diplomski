private static boolean isDriverAvailable() {    
    boolean driverAvailable = true;

    try {
        // Load any class that should be present if driver's available
        Class.forName("gnu.io.CommPortIdentifier");
    } catch (ClassNotFoundException e) {
        // Driver is not available
        driverAvailable = false; 
    }

    return driverAvailable;
}