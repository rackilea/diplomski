public static void main(String[] args) {
    while (true) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary number (END to exit): ");
        try {
            String inputValue = input.next();
            if (inputValue.equals("END")) {
                break;
            }
            if (!inputValue.matches("[01]+")) {
                throw new Exception("Invalid binary input");
            }

            int binarynum = Integer.valueOf(inputValue);
            int decimal = getDecimalValue(binarynum);
            System.out.println("Binary = " + binarynum + " Decimal = " + decimal);
            System.out.println();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

public static int getDecimalValue(int binary) {
    int decimal = 0;
    int power = 0;

    while (true) {
        if (binary == 0) {
            break;
        } else {
            int temp = binary % 10;
            decimal += temp * Math.pow(2, power);
            binary = binary / 10;
            power++;
        }
    }
    return decimal;
}