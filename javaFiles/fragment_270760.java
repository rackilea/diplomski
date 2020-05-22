public class NumberDecomposer {

public static void main(String[] args) {
    decompose(1212345);
    decompose(24123457);
}

private static void decompose(int modelCode) {
    System.out.println("Original modelCode="+modelCode);
    int factor = 1;
    int modelNumber = 0;
    while (modelCode >= 100) {
        int lastDigit = modelCode % 10;
        modelNumber += lastDigit * factor;
        factor *= 10;
        modelCode /= 10;
    }
    int productCode = modelCode % 10;
    int category = modelCode / 10;
    System.out.printf("Category=%d; Product=%d; Model number=%d\n", category, productCode, modelNumber);
}

}