public static void main(String[] args) throws FileNotFoundException {
        double[] dataArray = new double[] {1.5,2.5,3.5,4.5,7.5,8.5,2.5};
        int arraySizeToConsider = dataArray.length;
        double outlier;
        int index_outlier;
        double avg;
        double diffInOutlierAndAvg;

        while(arraySizeToConsider > 0) {
            outlier = dataArray[0];
            index_outlier = 0;
            avg = computeSum(dataArray,arraySizeToConsider) / (arraySizeToConsider);//avg of elements
            diffInOutlierAndAvg = Math.abs(avg - outlier);

            // find outlier
            for(int index = 0; index<arraySizeToConsider; index++)//increments index
            {
                if(Math.abs(avg - dataArray[index]) > diffInOutlierAndAvg) {
                    outlier = dataArray[index];
                    index_outlier = index;
                }
            }
            double temp = dataArray[arraySizeToConsider -1];
            dataArray[arraySizeToConsider -1] = outlier;
            dataArray[index_outlier] = temp;
            arraySizeToConsider = arraySizeToConsider -1;
            System.out.println("Average: " + avg + " Outlier: " + outlier + " index " + index_outlier + " array size to consider: " +arraySizeToConsider);
        }
    }
    private static double computeSum(double[] array, int arraySizeToConsider) {
        double sum = 0;
        for (int i = 0; i < arraySizeToConsider; i++) {
            sum = sum + array[i];
        }
        return sum;
    }