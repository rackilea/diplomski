private static int bufferSizeStatic = 1024;

private float[] Read(){
    // I don't know why you need to pass `bufferSize` here: `inputByteBuffer` already knows its own limit
        mAudioRecord.read(inputByteBuffer, bufferSize);
        return readByteArray(inputByteBuffer);
}

private float[] readByteArray(ByteBuffer byteBuffer) {
        if (floatArray == null || floatArray.length!=(byteArray.limit()-byteArray.position()) / (numChannels*numBytePerFrame)){
            floatArray = new float[(byteArray.limit()-byteArray.position()) / (numChannels*numBytePerFrame)];
        }

        byteBuffer.flip();
        if (numChannels == 1){
            for (int i = 0; i < floatArray.length; i++){
                short tempShort = (short) ((ByteBuffer.getShort(i*2));
                floatArray[i] = (float) (tempShort / 32768.0); 
            } 
        } //TODO add stereo support
        byteBuffer.compact();
        return floatArray;
    }