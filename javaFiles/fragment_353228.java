private static float readFloat(byte[] buffer, int index) {
    // not done in a loop for demonstration 
    int bits =  (buffer[index+0] & 255) 
             + ((buffer[index+1] & 255) <<  8) 
             + ((buffer[index+2] & 255) << 16) 
             + ((buffer[index+3] & 255) << 24);
    return Float.intBitsToFloat(bits);
}