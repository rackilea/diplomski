public static void getBinaryMsg(String codedMessage) {
    String binary = toBinary(codedMessage);
    System.out.println(binary);
  }

  private static String toBinary(String codedMessage) {
    String binary = codedMessage.chars().boxed().map(c -> pad(Integer.toBinaryString(c), 8, '0') + " ").collect(Collectors.joining());
    return binary;
  }

  private static String pad(String s, int n, char c) {
    return String.format("%"+n+"s", Integer.parseInt(s)).replace(' ', c);
  }