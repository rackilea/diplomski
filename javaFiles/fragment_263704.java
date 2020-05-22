public static void main(String[] args){

    double x1,y1;
    distance1 r  = new distance1();
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a number: ");
    x1 = input.nextDouble();

    System.out.print("Enter a number: ");
    y1 = input.nextInt();

    r.credit(x1, y1);
    System.out.println("Result is: "+ r.getResult());
}