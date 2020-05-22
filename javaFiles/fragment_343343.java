public static String convertToBinary(int decimal, int bits) {
    String binary = "";
    String need = "";
    int devision = decimal;
    while (devision > 0) {
        if (devision % 2 == 1) {
            devision /= 2;
            binary = '1' + binary;
        }
        if (devision % 2 == 0) {
            devision /= 2;
            if (devision > 0) {
                binary = '0' + binary;
            }
        }
    }
    if (binary.length() < bits) {
        int diffrence = bits - binary.length();
        for (int i = 0; i < diffrence; i++) {
            need = need + '0';
        }
        binary = need + binary;
    }
    return binary;
}