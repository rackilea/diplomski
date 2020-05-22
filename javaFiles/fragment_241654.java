public int read(byte[] into, int dstOffset, int length) {
    if (!isComplete()) {
        throw new IllegalStateException("Data is not complete yet");
    }

    int pointer = 0;
    int byteRead = 0;
    int total = 0;

    if (VERBOSE)
        Dog.d("Array size : " + data.length + " ID : " + id);
    for (int i = 0; i < data.length && (length > 0 || position >= limit); i++) {
        if (position > (pointer + data[i].length)) {
            pointer += data[i].length;
            if (VERBOSE)
                Dog.d("Skip -> I = " + i + ", Data length = " + data[i].length + ", Position = " + position + ", Pointer = " + pointer + ", Limit = " + limit);
        } else {
            if (VERBOSE)
                Dog.d("I = " + i + ", Data length = " + data[i].length + ", Position = " + position + ", Pointer = " + pointer + ", Limit = " + limit);
            // We are in the right array
            int srcOffset = position - pointer; // This is the starting position in our target array
            int relativeLimit = Math.min(limit - pointer, data[i].length); // The is the ending position in our target array

            byteRead = Math.min(relativeLimit - srcOffset, length); // Now the number is the byte read is either the number between start and end or the requested length

            if (VERBOSE)
                Dog.d("I = " + i + ", srcOffset = " + srcOffset + ", dstOffset = " + dstOffset + ", byteRead = " + byteRead + " out of " + data[i].length + " (limit is = " + limit + ", pointer = " + pointer + ")");
            System.arraycopy(data[i], srcOffset, into, dstOffset, byteRead);

            length -= byteRead; // We've read X bytes, so we still have to read (length - X)
            dstOffset += byteRead; // We need to start next write at previous position + X
            total += byteRead; // Counter to keep track of byte we've read

            pointer += data[i].length; // Current read position
            position += byteRead; // Current position
            if (VERBOSE)
                Dog.d("Left to write = " + length + ", byteRead = " + byteRead + ", total = " + total);
        }
    }

    if (VERBOSE)
        Dog.d("Wrote a total of :" + total);
    return total;
}