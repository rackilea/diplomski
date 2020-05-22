String string = "0100010111010001000011110111110100010110110011001010001101010010";
List<Integer> list = new ArrayList<Integer>();

for (int i = 0; i < string.length(); i++) {
    list.add(Integer.parseInt(String.valueOf(string.charAt(i))));
}