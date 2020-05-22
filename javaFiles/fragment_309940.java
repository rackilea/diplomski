public static void claimDevice(DeviceHandle handle, int interfaceNum){
    int r = LibUsb.detachKernelDriver(handle, interfaceNum);
    if (r != LibUsb.SUCCESS && 
        r != LibUsb.ERROR_NOT_SUPPORTED && 
        r != LibUsb.ERROR_NOT_FOUND) throw new LibUsbException("Unable to detach kernel     driver", r);
    .
    .
    .