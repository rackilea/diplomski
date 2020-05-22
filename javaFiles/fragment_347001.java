Scanner scannerToUsAll = new Scanner(System.in);

System.out.println("Enter Height of the room");
int height = scannerToUsAll.nextInt();

//here you check
if ( height < 2 && height > 6  ){
     System.out.println("The Height is not within the parameters (2 and 6)");
}