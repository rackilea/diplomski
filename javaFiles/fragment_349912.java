public static double[] makeArray() // Part f)
{
  final String format = "%.2f";
  Scanner input = new Scanner(System.in);

  System.out.print("\nHow many numbers: ");
  int numNumbers = input.nextInt();

  System.out.print("Enter lower and upper range limits: ");
  double lower = input.nextDouble();
  double upper = input.nextDouble();

  double[] numArray = new double[numNumbers];


  for (int i = 0; i < numNumbers; i++) {
    double number;
    System.out.printf("Enter number %d: ", i);
    number = input.nextDouble();

    while (number < lower || number > upper) {
      System.out.print("Please re-enter in range ");
      System.out.printf("[" + format + " to " + format + "]: ", lower, upper);
      number = input.nextDouble();
    }
    // YOU FORGOT TO ASSIGN THE GENERATED NUMBER TO ARRAY
    numArray[i] = number;
  }
  return numArray;


}