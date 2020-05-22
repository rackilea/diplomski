public static void main(String[] args) {
    checkType("5.2");
    checkType("5");
    checkType("s");
}

protected static void checkType(String input) {
    System.out.println(input);
    try {
        byte result = Byte.parseByte(input);
        System.out.println("could be interpreted as byte "+result);
    } catch (NumberFormatException e) {
        System.out.println("not an byte");
    }
    try {
        short result = Short.parseShort(input);
        System.out.println("could be interpreted as short "+result);
    } catch (NumberFormatException e) {
        System.out.println("not an short");
    }
    try {
        int result = Integer.parseInt(input);
        System.out.println("could be interpreted as int "+result);
    } catch (NumberFormatException e) {
        System.out.println("not an int");
    }
    try {
        long result = Long.parseLong(input);
        System.out.println("could be interpreted as long "+result);
    } catch (NumberFormatException e) {
        System.out.println("not an long");
    }
    try {
        float result = Float.parseFloat(input);
        System.out.println("could be interpreted as float "+result);
    } catch (NumberFormatException e) {
        System.out.println("not an float");
    }
    try {
        double result = Double.parseDouble(input);
        System.out.println("could be interpreted as double "+result);
    } catch (NumberFormatException e) {
        System.out.println("not an double");
    }
    try {
        boolean result = Boolean.parseBoolean(input);
        System.out.println("could be interpreted as boolean "+result);
    } catch (NumberFormatException e) {
        System.out.println("not a boolean");
    }
    if (input.length() == 1) {
        System.out.println("could be interpreted as character "+input);
    } else {
        System.out.println("not a character");
    }
    System.out.println();
}