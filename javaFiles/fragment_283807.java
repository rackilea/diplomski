while(true) {
    try {
        // Get the length first
        byte[] bytesLengthOfImage = new byte[4];
        mmInStream.read(bytesLengthOfImage);
        int lengthOfImage = 0;
        {
            ByteBuffer buffer = ByteBuffer.wrap(bytesLengthOfImage);
            buffer.order(ByteOrder.BIG_ENDIAN);  // Assume it is network byte order.
            lengthOfImage = buffer.getInt();
        }

        byte[] actualImage = new byte[lengthOfImage];   // Mind the memory allocation.
        mmInStream.read(actualImage);

        mHandler.obtainMessage(AppConstants.MESSAGE_READ, lengthOfImage,-1, actualImage).sendToTarget();
    } catch (Exception e) {
        if(e instanceof IOException) {
            // If the connection is closed, break the loop.
            break;
        }
        else {
            // Handle errors
            break;
        }
    }
}