int numberOfBottles = 100;
if (versesToPrint <= 100)
{   
    for (int i = 0; i < versesToPrint; i++)
    {
    System.out.println (numberOfBottles + " bottles of beer on the wall");
    System.out.println (numberOfBottles + " bottles of beer");
    System.out.println ("If one of those bottles should happen to fall"); 
    System.out.println (numberOfBottles - 1  + " bottles of beer on the wall");
    numberOfBottles--;
    }
}