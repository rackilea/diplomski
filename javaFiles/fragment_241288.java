//Check if location is turned on and your app is allowed to use it.
if (Display.getInstance().getLocationManager().isGPSDetectionSupported()) {
    if (Display.getInstance().getLocationManager().isGPSEnabled()) {
        InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        //Cancel after 20 seconds
        Location loc = LocationManager.getLocationManager().getCurrentLocationSync(20000);
        ipDlg.dispose();
        if (loc != null) {
            double lat = loc.getLatitude();
            double lng = loc.getLongitude();
            try {
                Display.getInstance().sendSMS("09123456789", "http://maps.google.com/?q=" + lat + "," + lng, false);
            } catch (IOException ex) {
                Dialog.show("Error!", "Failed to start.  installed?", "OK", null);
                ex.printStackTrace();
            }
        } else {
            Dialog.show("GPS error", "Your location could not be found, please try going outside for a better GPS signal", "Ok", null);
        }
    } else {
        Dialog.show("GPS disabled", "AppName needs access to GPS. Please enable GPS", "Ok", null);
    }
} else {
    InfiniteProgress ip = new InfiniteProgress();
    final Dialog ipDlg = ip.showInifiniteBlocking();
    //Cancel after 20 seconds
    Location loc = LocationManager.getLocationManager().getCurrentLocationSync(20000);
    ipDlg.dispose();
    if (loc != null) {
        double lat = loc.getLatitude();
        double lng = loc.getLongitude();
        try {
            Display.getInstance().sendSMS("09123456789", "http://maps.google.com/?q=" + lat + "," + lng, false);
        } catch (IOException ex) {
            Dialog.show("Error!", "Failed to start.  installed?", "OK", null);
            ex.printStackTrace();
        }
    } else {
        Dialog.show("GPS error", "Your location could not be found, please try going outside for a better GPS signal", "Ok", null);
    }
}