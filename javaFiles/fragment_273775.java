public static void main(String[] args) throws Exception  {

    // TODO Auto-generated method stub
    char furntype;
    char fabtype;
    int c =1000;
    int C =1000;
    int l =750;
    int L =750;
    int r =1200;
    int R =1200;
    String couch="";
    Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter the type of furniture you want! "+
         "C for couch L for loveseats, and R for Recliner");

    //Take user input as a String, and get the first char.
    furntype = scanner.nextLine().charAt(0);


    if (furntype == 'c' || furntype == 'C')
        System.out.println("You chose a couch! It sells for $ " + c);

    else if (furntype == 'l' || furntype == 'L')
        System.out.println("You chose a loveseat! It sells for $750");

    else if (furntype == 'r' || furntype == 'R')
        System.out.println("you chose recliner! It sells for $1200");

    else
        System.out.println("Invalid choice");


    System.out.println("Would you like fabric or "+
        "leather for the couch, leather costs 35% more.");

    //Get the first char of input string
    fabtype = scanner.nextLine().charAt(0);


    if (fabtype == 'f' || fabtype =='F')
        System.out.println("you selected fabric! your total is $" + furntype);

    else if (fabtype == 'l' || fabtype =='L')
        System.out.println("you chose leather! your new total is $" + fabtype);

    else{
        System.out.println("Invalid choice");
    }
}