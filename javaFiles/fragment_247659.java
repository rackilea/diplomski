Map<Object, Device> devicesToDelete = new HashMap<>();
List<Device> oldDeviceList = getCurrentDevices();

for(Device deviceFromOldList: oldDeviceList) {
    devicesToDelete.putIfAbsent(deviceFromOldList.id, deviceFromOldList);
}

// in case you need a Collection:
Collection<Device> allDevicesToDelete = devicesToDelete.values();