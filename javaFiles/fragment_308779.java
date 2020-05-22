if (mode == this.modeOfOperation.CBC) {
        padLength = 16 - (bytesIn.length % 16);
    }
    // the AES input/output
    if (bytesIn !== null)
    {
        for (var j = 0;j < Math.ceil((bytesIn.length + padLength)/16); j++)
        {
        ....