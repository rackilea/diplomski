public static boolean checkSolution(double[][] matrix, double[] vector)
{
    HashSet<Double> arraySet = new HashSet<Double>();

    for (int line = 0; line < matrix.length; line++)
    {
        arraySet.clear();
        for (int column = 0; column < matrix[line].length; column++)
        {
            arraySet.add(matrix[line][column]);
        }
        if (!(arraySet.size() == 1) || !(arraySet.contains(0.0)))
        {
            return false;
        }
    }   
    return true;
}