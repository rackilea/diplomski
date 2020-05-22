public static void main(String[] args) {
    List<String> list = Arrays.asList("123",
      "1-2",
      "0987654321098765432109876543211",
      "098765432109876543210987654321a-b-c");
    System.out.println(splitByWords(list));
  }