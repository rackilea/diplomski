int i = 1;
while(i == 1)
{
  int choice = input.nextInt();
  switch(choice)
  {
    case 1:
        System.out.println("Add");
        break;
    case 2:
        System.out.println("Edit");
        break;
    case 3:
        System.out.println("Delete");
        break;
    case 4:
        System.out.println("Search");
        break;
    case 5:
        i = 2;
        break;
    default:
        System.out.println("Invalid Choice .. Try Again.");
  }
}