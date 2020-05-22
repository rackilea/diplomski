//create a socket connection to another device
Socket socket = new Socket("123.123.123.123",65535);//or w/e socket address you are using

//wrap the socket with a parcel so you can get at its underlying File descriptor
ParcelFileDescriptor socketWrapper = ParcelFileDescriptor.fromSocket(socket);

//set your mediaRecorder instance to write to this file descriptor
mediaRecorder.setOutputFile(socketWrapper.getFileDescriptor());