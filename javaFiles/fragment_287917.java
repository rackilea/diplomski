static double sd(int[] numbers) {

    double mean = mean(numbers);
    double std_dev = 0;

    for (int i=0; i<numbers.length; i++) {
        std_dev += Math.pow(mean - (double) numbers[i], 2);
    }

    // This gets the population standard deviation 
    return Math.sqrt(std_dev / (double) (numbers.length-1) );


}