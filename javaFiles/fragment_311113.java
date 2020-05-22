public static void main(String args[]) {
  BFInterpreter a = new BFInterpreter(
      "+[.+]".toCharArray(), new byte[1], false);
  a.execute();
  String output = a.output();
  for (Character c : output.toCharArray()) {
    System.out.print(Integer.toString((int) c)); // You want this method.
    System.out.print(" ");
  }
  System.out.println();
}