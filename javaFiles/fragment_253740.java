Scanner input = new Scanner(System.in);
System.out.println("Which Index would you like to adjust?");
int change = input.nextInt();

System.out.println("What would you like to change about Index " + change + "?");
System.out.println("Enter 1 for the Name.");
System.out.println("Enter 2 for the Product ID.");
System.out.println("Enter 3 for the Price.");
System.out.println("Enter 4 for the Expiration Date.");
int type = input.nextInt();
Prod p = pList.get(change);

if(type==1){ 
   p.setName(input.nextLine());
}
else if(type==2){
   p.setId(input.nextLine());
}
///and so on