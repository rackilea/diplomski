private static void add(String[] args) {
  if (args.length == 1) {
    System.out.print("Error: Argument count mismatch");
  }
  int num = 0;
  for (int i = 1;i < args.length;i++) {
    if (isInteger(args[i]) == false) {
      System.out.print("Error: Argument type mismatch");
    }
    else {
    int a = Integer.parseInt(args[i]);
    num += a;
    }
  }
  System.out.println(num);
}