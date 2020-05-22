ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.fromDatagramSocket(udpSocket);
FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
FileInputStream fin = new FileInputStream(fileDescriptor);

byte[] receiveData = new byte[1328];
int readByte = fin.read(receiveData);