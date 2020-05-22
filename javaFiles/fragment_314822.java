public static double[][] Double2DMatrixFromFile(String input) throws IOException 
{

    Path path = Paths.get(input);
    return Files.lines(path)
                .map(x -> new double[]{Double.parseDouble(x)})
                .toArray(double[][]::new);

}