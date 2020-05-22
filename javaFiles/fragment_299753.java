DeviceHandle handle = new DeviceHandle();
    result = LibUsb.open(device, handle);
    if (result < 0) {
        System.out.println(String.format("Unable to open device: %s. "
            + "Continuing without device handle.",
            LibUsb.strError(result)));
        handle = null;
    }