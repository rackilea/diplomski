public static void main (String []args){
    BusPayment test = new BusPayment();

    Scanner input=new Scanner(System.in);
    System.out.println("Payment");
    System.out.println("The price of an adult ticket is 15.00.");
    System.out.println("The price of a children's ticket is 10.00.");

    System.out.println("Enter number of adults:");
    test.number_of_adults=input.nextInt();
    System.out.println("The number of adults are: "
            +test.number_of_adults);

    System.out.println("Enter number of children:");
    test.number_of_children=input.nextInt();
    System.out.println("The number of children are:"+test.number_of_children);

    double totalpri = test.calculate_totalprice();
    System.out.println("The total price you need to pay: "
            +totalpri);

}