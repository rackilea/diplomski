RemoteDevice createDevice (String className, String hardwareAddress) throws Exception {
    Class clazz = Class.forName(className);

    Constructor<RemoteDevice> constructor = clazz.getConstructor(new Class[]{String.class});
    RemoteDevice result = constructor.newInstance(hardwareAddress);
    return result;
}