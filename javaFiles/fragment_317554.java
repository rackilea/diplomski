String input = "";
Scanner scn = new Scanner(System.in);    

do{
    System.out.print("Please enter account number:");
    input = scn.nextLine();
}while(input.length() != 9);

accountNumbers.add(input);    //Note: I write "accountNumbers" instead of "AccountNumber"