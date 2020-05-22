public static void readRecords()
{
    System.out.printf("%s%s%s%s" , "Team Id", "TeamNAme","CoachFirst", "CoachLast");
    try
    {
        while (input.hasNext())
        {
            System.out.printf("%s%s%s%s",input.nextInt(),input.next(),input.next(),input.next());
            input.nextLine();  // skip remainder of line
        }

    }
    catch (NoSuchElementException statException)
    {
        System.err.println("File improperly formed.");
    }
    catch (IllegalStateException stateException)
    {
        System.err.println("ERROR READING FROM FILE");
    }
}