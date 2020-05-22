Scanner sc;
//...
System.out.println("Please enter a number");
while (!sc.hasNextInt()){
    sc.nextLine();  // throw away the bad input
    System.out.println("Please enter a valid number");
}
int theNum = sc.nextInt();