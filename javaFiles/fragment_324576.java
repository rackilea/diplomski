private static SharedData instance = new SharedData();   \\ Initialize here

private SharedData() {        // Make it private....
    // randomizeServers();
}

// data to be shared
private double src_latitude = -1;
private double src_longitude = -1;
private double end_latitude = -1;
private double end_longitude = -1;

//Getter-Setters
public static SharedData getInstance() {
    return instance;
}