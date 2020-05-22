byte[] in = new byte[] { 1, 2, 3, -1, -2, -3 };
System.out.println(byteArrayToString(in));

String byteArrayToString(byte[] in) {
    char out[] = new char[in.length * 2];
    for (int i = 0; i < in.length; i++) {
        out[i * 2] = "0123456789ABCDEF".charAt((in[i] >> 4) & 15);
        out[i * 2 + 1] = "0123456789ABCDEF".charAt(in[i] & 15);
    }
    return new String(out);
}