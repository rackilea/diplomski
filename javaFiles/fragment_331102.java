public static void main (String[] args)
{
    int numEach = 0; // or some other default value that makes sense
    int boatSize = 0; // or some other default value that makes sense
    if (args.length > 1)
        numEach = Integer.parseInt(args[1]);
    if (args.length > 3)
        boatSize = Integer.parseInt(args[3]);
    RiverCrossingPuzzle puzzle = new RiverCrossingPuzzle (numEach, boatSize);
}