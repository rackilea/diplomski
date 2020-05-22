byte [] array = new byte[]{0x7F,0x11,0x22,0x33,0x44,0x55,0x66,0x77};

// create from array
BigInteger bigInt = new BigInteger(array);

// shift
BigInteger shiftInt = bigInt.shiftRight(4);

// back to array
byte [] shifted = shiftInt.toByteArray();

// print it as hex
for (byte b : shifted) {
    System.out.print(String.format("%x", b));
}