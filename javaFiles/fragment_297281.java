String binString = "11010011100101010001100010010010";
StringBuilder onesComplementBuilder = new StringBuilder();
for(char bit : binString.toCharArray()) {
    // if bit is '0', append a 1. if bit is '1', append a 0.
    onesComplementBuilder.append((bit == '0') ? 1 : 0);
}
String onesComplement = onesComplementBuilder.toString();
System.out.println(onesComplement); // should be the NOT of binString
int converted = Integer.valueOf(onesComplement, 2);
// two's complement = one's complement + 1. This is the positive value
// of our original binary string, so make it negative again.
int value = -(converted + 1);