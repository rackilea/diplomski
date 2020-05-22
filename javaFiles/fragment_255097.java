public static int countDoubles(File file) throws FileNotFoundException
{
    // Create a scanner to read the file.
    Scanner reader = new Scanner(file);

    // Count of the doubles in the file.
    int count = 0;

    while (reader.hasNextDouble())
    {
        // Consume each double and increment the counter.
        count++;
        reader.nextDouble();
    }

    reader.close();
    return count;
}