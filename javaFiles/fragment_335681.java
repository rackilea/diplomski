public static void main(String[] args) {
  int positive = 0;
  System.out.println("Input the integers at the console and press <Enter>");

  Scanner input = new Scanner (System.in);
  for (int i = 1; i <= 5; i++) {
    System.out.println("Input the " + i + "st integer:");
    int x = input.nextInt();
    if (x > 0) positive++;
  }
  input.close();
  System.out.println ("The number of positive integers are: " + positive );
}