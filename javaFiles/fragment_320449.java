byte[] out = new byte[lengthText]; // initialized with 0s
int n = 0;
for (int i = 0; i < lengthText; i++) {
    out[i] = data1[n] ^ data2[n]; // assuming that both arrays have more that 0 elements
    n = (n + 1) % Math.min(data1.length, data2.length); // just in case their length differ
}