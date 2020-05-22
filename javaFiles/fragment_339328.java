public static double mode(Double[] values) {

    List<Double> list = Arrays.asList(values);
    int max = Integer.MIN_VALUE;
    int count = 0;
    double mode = 0;
    for(Double i: list) {
        count = Collections.frequency(list, i);
        if(count > max) {
            max = count;
            mode = i;
        }
    }
    return mode;  
}