public static double computeSumPositive( double[] numbers, int count )
    {
        double total = 0;
        {
            if( count > 0 )
            {
                double val = (numbers[count - 1] > 0)?numbers[count - 1]:0;
                total = val + computeSumPositive( numbers, count - 1 );
                return total;
            }
            else
                return total;
        }
    }