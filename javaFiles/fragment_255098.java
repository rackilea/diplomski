public static double[] readDoubles(File file, int numberOfDoubles) throws FileNotFoundException
{
    // Create a scanner to read the file.
    Scanner reader = new Scanner(file);

    // Create an array to store the values.
    double[] values = new double[numberOfDoubles];

    for (int i = 0; i < values.length && reader.hasNextDouble(); ++i)
    {
        // Consume each value and insert it into the array.
        values[i] = reader.nextDouble();
    }

    reader.close();
    return values;
}