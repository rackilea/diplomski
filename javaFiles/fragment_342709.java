Scanner scan = new Scanner(System.in);
System.out.print("Please enter a number");
int num = scan.nextInt(); // take the input from the user.

if(num >= 7 && num <=11){ //case to make sure that the number lies between 7 and 11 inclusively
    System.out.print("The number "+num+" lies between 7 and 11");
}
else{
    System.out.println("The number "+num+" does not lie between 7 and 11");
}