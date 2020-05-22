public static int convertBinStrToInt(String binStr) {
    int dec = 0, count = 0;
    for (int i = binStr.length()-1; i >=0; i--) {
        dec += (binStr.charAt(i) - '0') * (1 << count++);
    }

    return dec;
}