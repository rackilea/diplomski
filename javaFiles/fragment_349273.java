GPSTracker gpsTracker;

public GPSTracker getGPSTrackerInstance() {

    if(gpsTracker == null) 
        gpsTracker = new GPSTracker();

    return gpsTracker;
}