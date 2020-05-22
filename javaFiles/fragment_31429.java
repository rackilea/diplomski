byte[] unpadZerosToGetAesKey(byte[] in) {
    int i = 0;
    while(in[i] == 0) i++;
    int len = in.length - i;
    if (len <= 16) len = 16;
    else if (len <= 24) len = 24;
    else len = 32;
    return Arrays.copyOfRange(in, in.length - len, in.length);
}