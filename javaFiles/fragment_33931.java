while (option == 1)
{
    a.generate();
    a.count();
    System.out.println("Max number is "+ a.maximum(max));
    System.out.println("Average number is "+ a.average(aver));
    System.out.println("Min number is "+ a.minimum(min));
    System.out.println("Do you want to run it again (y/n)?: ");
    option = a.getchoice();
}