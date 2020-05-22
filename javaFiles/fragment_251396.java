private <T extends Enum<T> & IDevice> T getDeviceByReadableName(String versionInXml, Class<T> deviceClass) {
    for (T device : deviceClass.getEnumConstants()) {
        if (<some-condition>)
            return device;
    }
    return null;
}