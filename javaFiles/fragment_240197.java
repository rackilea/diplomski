public static short[] decompress(short[] input) {
    int outputLength = 0;

    /* First we need to figure out how long the output is
       going to be when uncompressed, so we iterate through
       the input like we are would normally, but write no output,
       instead computing the output length */

    //note the += 2; we want to skip the actual output
    for(int i = 0; i < input.length; i += 2) {
        outputLength += input[i]; //increment target length
    }

    /* Now that we know what the output size will be,
       we can create an array to store it. */
    short[] output = new short[outputLength];

    /* Now iterate over the input, putting every other input short
       into the output, duplicated the number of times of the current input 
       AKA: decompression of RLE */
    for(int i = 0, outOffset = 0; i< input.length; i += 2) {
        for(int ii = 0; ii < input[i]; ii++)
            output[ii + outOffset++] = input[i + 1];
    }
    return output;
}