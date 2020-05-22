public static void main (String args[])
{
  String itemName;
  int itemNum;
  int itemQuan;
  double unitCost;
  Mobile mobileValues[] = new Mobile[5];

  for(int i=0;i<5;i++)
  {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter Item Name: ");
      itemName = input.nextLine();
      System.out.print("Enter Item Number: ");
      itemNum = input.nextInt();         
      System.out.print("Enter Quantity of Item: ");
      itemQuan = input.nextInt();

      System.out.print("Enter Price of Single Unit: ");
      unitCost = input.nextDouble();

      mobileValues[i] = new Mobile(itemName, itemNum, itemQuan, unitCost);
  }
}