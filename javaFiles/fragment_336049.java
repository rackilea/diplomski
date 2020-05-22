if (deviceUUID != null) {
    ParcelUuid[] uuids = device.getUuids();
    if (uuids != null && uuids.length > 0) {
        UUID uuid = uuids[0].getUuid();
        deviceUUID.setText(uuid.toString());
    }
}