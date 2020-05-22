int Model; //model number
Scanner input = new Scanner(System.in);

do{
  System.out.print("Enter the car's model number or 0 to quit: ");
  Model=input.nextInt();

  if (Model==119||Model==179||(Model>=189 && Model<=195)||Model==221||Model==780)
      System.out.println("Your car is defective. It must be repaired.");
  else if(Model>0)
      System.out.println("Your car is not defective.");
}while(Model>0);
input.close();