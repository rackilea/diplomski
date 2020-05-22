public static double[] DoubleArrayFromFile(String input) throws IOException
{
    Path path = Paths.get(input);
    return Files.lines(path)
                .mapToDouble(Double::parseDouble)
                .toArray();
}