String s = "abcdefghij".substring(2, 5);
int logicalLength = s.length();
int valueLength = getValueLength(s);

System.out.printf("%d %d ", logicalLength, valueLength);
if (logicalLength != valueLength) {
    System.out.println("shared");
else
    System.out.println("unshared");