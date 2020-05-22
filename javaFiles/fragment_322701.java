if (bluetooth != null) {

    if (bluetooth.isEnabled()) {
        String mydeviceaddress = bluetooth.getAddress();
        String mydevicename = bluetooth.getName();
        status = mydevicename + ":" + mydeviceaddress;
    } else {
        status = "Bluetooth is not Enabled.";
    }
    //etc...