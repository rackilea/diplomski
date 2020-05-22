if (readMap != null && !readMap.isEmpty()) { // Swap the order, can't check empty if it's null.
    isWritten = true;
    isDeviceSideEnabled();
    Platform.runLater(() -> {
        editDeviceContents.setDisable(false);
        vehicleId.setText(readMap.get(0));
        vehicleName.setText(readMap.get(1));
        deviceType.setText(readMap.get(2));
        offboardBroker1.setText(readMap.get(3));
        offboardBroker2.setText(readMap.get(4));
        postfixQueue.setText(readMap.get(5));
        pKIServer.setText(readMap.get(6));
        lContentsSerialNo.setText(readMap.get(7));
    });
}