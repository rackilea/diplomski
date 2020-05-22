private static boolean accept(File file)
{
    // this is what I gather from your description
    boolean containsNull = false;
    boolean containsMA = false;
    try (Scanner scanner = new Scanner(file))
    {
        while (scanner.hasNextLine())
        {
            final String line = scanner.nextLine();
            if (line.contains("DEBUG - null"))
            {
                containsNull = true;
            }
            if (line.contains("DEBUG - MA") || line.contains("INFO - MA"))
            {
                containsMA = true;
            }
        }
        return containsMA || !containsNull;
    }
    catch (FileNotFoundException e)
    {
        return false;
    }
}