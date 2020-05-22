gateways
    .parallelStream()
    .map(Gateway::getDevices)
    .flatMap(List::stream)
    .filter(Device::isDisconnected)
    .forEach(Device::reconnect);