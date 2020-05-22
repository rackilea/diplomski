Octagon first = null;
int i = 0;
while(fin.hasNext())
{
    double side = fin.nextDouble();
    if(side < 0.0)
        break;
    Octagon oct = new Octagon(side);
    System.out.print("Octagon " + i + ": \"" + oct.toString() + "\"");
    if (first == null)
        first = oct;
    else
    {
        // Here is where we compare the current Octagon to the first one
        int comparison = oct.compareTo(first);
        if (comparison < 0)
            System.out.print(", less than first");
        else if (comparison > 0)
            System.out.print(", greater than first");
        else System.out.print(", equal to first");
    }
    Octagon first = new Octagon(side);
    System.out.println();
}