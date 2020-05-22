public class Factorial{
    public static void main(String args[]){

    Scanner x = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int number = x.nextInt();
    Series s=new Series(number);
    s.print();
    x.close();
}