public class WorkProject {
    public static void main(String[] args) throws FileNotFoundException {

      Scanner inFile = new Scanner(new FileReader("C:\\staffnumbers.txt"));

      double Hours;
      double Pay;

      Hours = inFile.nextDouble();
      Pay = inFile.nextDouble();
      double amountEarned = Hours * Pay;

      System.out.println(amountEarned);
    }
}