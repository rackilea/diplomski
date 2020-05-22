...
const pairedDevices = adapter.getBondedDevices().toArray();
pairedDevices.forEach((device) => {
  let newDevice = {
    type: 'scanResult',
    UUID: device.getAddress(),
    name: device.getName(),
    RSSI: 0,
    state: 'disconnected'
  }

  obArrayDevices.add(newDevice);
});
....