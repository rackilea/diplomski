//make a pipe containing a read and a write parcelfd
ParcelFileDescriptor[] fdPair = ParcelFileDescriptor.createPipe();

//get a handle to your read and write fd objects.
ParcelFileDescriptor readFD = fdPair[0];
ParcelFileDescriptor writeFD = fdPair[1];

//next set your mediaRecorder instance to output to the write side of this pipe.
mediaRecorder.setOutputFile(writeFD.getFileDescriptor());

//next create an input stream to read from the read side of the pipe.
FileInputStream reader = new FileInputStream(readFD.getFileDescriptor());

//now to fill up a buffer with data, we just do a simple read
byte[] buffer = new byte[4096];//or w/e buffer size you want

//fill up your buffer with data from the stream
reader.read(buffer);// may want to do this in a separate thread