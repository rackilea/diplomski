public class PolynomialDemo  {
public static int degree;
public static double[] numbers;

public static void main(String[] args) {

    //Create a Polynomial object
    Polynomial pol = new Polynomial();

    Scanner scan = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the degree of the first polynomial -> ");
    degree = scan.nextInt();

    System.out.print("Enter its coefficients in order of descending powers -> ");
    String deg = scanner.nextLine();
    String[] numbersStr = deg.split(" ");
    double[] numbers = new double[ numbersStr.length ];
    for ( int i = 0; i < numbersStr.length; i++ )
    {
        numbers[i] = Integer.parseInt( numbersStr[i] );
    }


    //Set values
    pol.setDegree(degree);
    pol.setCoefficients(numbers);