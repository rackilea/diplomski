UsbManager myUsbManager = (UsbManager) 
getSystemService(Context.USB_SERVICE);
UsbAccessory myUsbAccessory = (myUsbManager.getAccessoryList())[0];
ParcelFileDescriptor pfd = myUsbManager.openAccessory(myUsbAccessory);
FileDescriptor fileDescriptor = pfd.getFileDescriptor();
FileInputStream myFileInputStream = new FileInputStream(fileDescriptor);
FileOutputStream myFileOutputStream = new FileOutputStream(fileDescriptor);