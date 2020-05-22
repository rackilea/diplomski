StringBuilder thisPart = new StringBuilder("12345678901234567890");
try {
    BigInteger intVal = new BigInteger(thisPart.toString());
} catch (NumberFormatException e) {
    System.out.println("Bad value");
    isBad = true;
    break; // or return or what have you
}