String scanner1 = sc1.nextLine();
name [i] = scanner1;

System.out.println("Input weight: ");

double scanner2 = sc2.nextDouble();
if(!sc1.hasNextDouble())
{
    System.out.println("Invalid Weight!. Start Again");

} else
{
    weightkg[i] =  scanner2;
}