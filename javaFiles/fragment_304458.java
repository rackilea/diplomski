for (int t = 0; t + 4 < eightBitByteArray.length; t += 4) // t+4 -> skip
                                                          //2nd channel
{
    float value = ByteBuffer.wrap(eightBitByteArray, t, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    double dB = 0;
    if (value != 0) {
        dB = 20.0 * Math.log10(value); // calculate decibel
    }

    toReturn[index] = getFloatValue(dB); //minorly important conversion 
                                         //to normalized values

    index++;
}