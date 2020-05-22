public class IntBaseConverter {
public static void main(String[] args) {
    convert(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
}

public static void convert(int decimalValue, int base) {
    String result = "";
    while (decimalValue >= base) {
        result = decimalValue % base + result;
        decimalValue /= base;
    }
    result = decimalValue + result;

    System.out.println(result);
}
}