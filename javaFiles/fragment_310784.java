1. We have to traverse from backwards as we do in the binary to decimal conversion.
2. If the character is '1', then we will add the value of power of 2.

public static int binaryToDecimal(String binary) {
        int value = 0,power = 0;
        for(int i = binary.length() - 1; i >= 0;i--) {
            if(binary.charAt(i) == '1') {
                value += Math.pow(2, power);
            }
            power++;
        }
        return value;
    }