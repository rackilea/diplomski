public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    //Show Keyset
    Length.printMap();


    System.out.println("What length you want to confert from");
    String to = input.nextLine();

    System.out.println("What length you want to confert to");
    String from = input.nextLine();

    System.out.println("Input length");
    double value = input.nextDouble();

    int result = (int) Length.convert(value, from, to);
    System.out.println((int) value + from + " = " + result + to);
}