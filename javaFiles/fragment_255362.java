public void computeAverage(int [] scores)
{
    double average = 0;
    for (int i = 0; i < scores.length; i++)
    {
        average += scores[i];
    }

    average /= scores.length;

    System.out.print(average);
}