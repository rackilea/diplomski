public static void findClosestRowsToMultiplesOfTen() {
    // fake row values
    double[] vals = new double[]{ 0.5, 12.10, 13.00, 16.01, 21.52 };

    //  get the max value, and its multiple of ten to get the number of buckets
    double max = Double.MIN_VALUE;
    for (double v : vals) max = Math.max(max, v);
    int bucketCount = 1 + (int)(max/10);

    //  initialise the buckets array to store the closest values
    double[][] buckets = new double[bucketCount][3];
    for (int i = 0; i < bucketCount; i++){
        // store the current smallest delta in the first element
        buckets[i][0] = Double.MAX_VALUE; 
        // store the current "closest" index in the second element
        buckets[i][1] = -1d;
        // store the current "closest" value in the third element
        buckets[i][2] = Double.MAX_VALUE;
    }

    //  iterate the rows
    for (int i = 0; i < vals.length; i++)
    {
        //  get the value from the row
        double v = vals[i];
        //  get the closest multiple of ten to v
        double mult = getMultipleOfTen(v);
        //  get the absolute distance of v from the multiple of ten
        double delta = Math.abs(mult - v);
        //  get the bucket index based on the value of `mult`
        int bIdx = (int)(mult / 10d);
        //    test the last known "smallest delta" for this bucket
        if (buckets[bIdx][0] > delta)
        {
            //  this is closer than the last known "smallest delta"
            buckets[bIdx][0] = delta;
            buckets[bIdx][1] = i;
            buckets[bIdx][2] = v;
        }
    }

    //   print out the result
    System.out.format("    10x row value%n");
    for (int i = 0; i < buckets.length; i++)
    {
        double[] bucket = buckets[i];
        int multipleOfTen = i * 10;
        double rowIndex = bucket[1];
        double rowValue = bucket[2];
        System.out.format("    %,2d %,4.0f %.4f%n", 
          multipleOfTen, rowIndex, rowValue);
    }
}
public static double getMultipleOfTen(double v)
{
    return 10d * Math.round(v / 10d);
}