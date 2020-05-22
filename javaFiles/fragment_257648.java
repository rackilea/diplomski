double[] foo = new double[100]; //store the sum at any point in array
    double sum = 1d; //first value
    double denominator = 1d; //first denominator
    for (int i = 0; i < foo.length; i++) {
        foo[i] = sum; //set the sum to i (1, 2, 2.5, ...)
        System.out.println(i + ":" foo[i]);
        denominator *= (i + 1); //calculate the next factorial, (1, 2, 3)
        sum += 1d / denominator; //calculate the sum (2, 2.5, ...)
    }