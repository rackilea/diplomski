String input = "This is a sentence.";
String[] split = input.split(" ");
Map<String, String[]> map = new HashMap<>(split.length - 1);
for (int i = 0; i < split.length - 1; i++) {
    int remainderLength = split.length - 1 - i;
    String[] remainders = new String[remainderLength];
    System.arraycopy(split, i + 1, remainders, 0, remainderLength);
    map.put(split[i], remainders);
}