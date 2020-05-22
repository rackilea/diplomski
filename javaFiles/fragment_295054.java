public static String decimalToBinary(int value) {
    String binary = "";
    int i = 0;
    while (value > 0) {
        i = value % 2;
        value = value / 2;
        if (i == 1) {
            binary = binary + "1";
        }
        else {
            binary = binary + "0";
        }
    }
    return binary;
}