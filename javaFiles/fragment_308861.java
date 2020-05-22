public class toBinary {

    public static void main(String[] args) {
        System.out.println(decimalToBinary(16317));
        System.out.println(binaryToDecimal("11111111111111111111111111111111111100101001"));
    }

    public static long binaryToDecimal(String bin) {
        long result = 0;
        int len = bin.length();
        for(int i = 0; i < len; i++) {
            result += Integer.parseInt(bin.charAt(i) +  "") * Math.pow(2, len - i - 1);
        }
        return result;
    }

    public static String decimalToBinary(long num) {
        String result = "";
        while(true) {
            result += num % 2;
            if(num < 2)
                break;
            num = num / 2;
        }
        for(int i = result.length(); i < 32; i++)
            result += "0";
        result = reverse(result);
        result = toLittleEndian(result);
        return result;
    }

    public static String toLittleEndian(String str) {
        String result = "";
        result += str.substring(24);
        result += str.substring(16, 24);
        result += str.substring(8, 16);
        result += str.substring(0, 8);
        return result;
    }

    public static String reverse(String str) {
        String result = "";
        for(int i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }

}