public static double q1(ArrayList<String> input1){
    double sum1 = 0;
    for (String s1: input1){
         sum1 += s1.length(); //Line 6
    }
    return Math.pow(sum1, 3);
}