public static void main(String[] args)
{
  // Say the size is given in a command line argument.
  int coefficientNumber = Integer.parseInt(args[0]);

  int[] poly = new int[coefficientNumber];
  for (int i = 0; i < poly.length; i++)
  {
    poly[i] = 0;
  }
  // Set the highest coeffient to 1 (if there is 3 coefficients, this is coefficient
  // of x^2, if 4 coefficients, this is coefficient of x^3
  poly[0] = 1;
  printPoly(poly);
}

// To print a polynomial of unknown length.
// If the coefficient is 0, don't print it.
private static void printPoly(int[] poly)
{
  String output = "";
  for (int index = 0; index < poly.length; index++)
  {
    if (poly[index] != 0)
    {
      // If this is the first coefficient with a value
      if (output.length() == 0)
        output = poly[index] + "x^" + (poly.length - (index + 1));
      // Else if there is already some coefficient with values printed.
      else
        output += " + " + "x^" + (poly.length - (index + 1));
    } // if
  } // for
  System.out.println(output);
} // printPoly