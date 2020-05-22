List<String> connectedIds = new ArrayList<String>(getConnectedDevices());
List<Device> allDbDevicesAsList = getAllDbDevicesAsList();

List<Device> connectedDevices = new ArrayList<Device>();

for (int i = 0; i < allDbDevicesAsList.size(); i++) {
    Device currentDevice = allDbDevicesAsList.get(i);
    boolean removed = connectedIds.remove(currentDevice.uuid);
    if (removed) {
        connectedDevices.add(currentDevice);
    }
}