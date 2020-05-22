// Fill it
    int numRead = 0;
    int offset = 0;
    while (numRead != -1) {
        numRead = stream.read(audioData[0], offset - numRead, len - numRead);
    }