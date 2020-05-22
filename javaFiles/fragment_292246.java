byte[] byteArray = ...;  // your array
// DECODE: convert to sample values
int[] samples = byteArray.length / 2;
for (int i=0; i<samples.length; i++) {
    samples[i] = byteToShortLittleEndian(byteArray, i*2);
}
// now do your manipulation on the samples array
[...]
// ENCODE: convert back to byte values
byte[] byteOut = new byte[byteArray.length];
for (int i=0; i<samples.length; i++) {
    byte[] b = shortToByteLittleEndian(samples, i);
    byteOut[2*i] = b[0];
    byteOut[2*i+1] = b[1];
}
// do something with byteOut ...