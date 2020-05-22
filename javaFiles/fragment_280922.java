public class MultiplicationTableTester {

public static void main (String[] args) {
    int maxNum;
    System.out.println("Please enter a number: ");

    Scanner in = new Scanner(System.in);
    maxNum = in.nextInt();

    MultiplicationTable mT = new MultiplicationTable(maxNum);

    System.out.print(mT.createMultiplicationTable());
  }
}