final Scanner in = new Scanner(System.in);
while (true) {
  try {
    int choose = in.nextInt();
    if (choose == 1 || choose == 2 || choose == 3) {
      return choose;
    } else {
      System.out.println("else text");
    }
  } catch (InputMismatchException e) {
    System.out.println("exception text");
  }
}