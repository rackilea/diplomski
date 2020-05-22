public  static  double standardDeviation(int[] numbers) {
    double jo = 0.0;
    for(int i=0; i<numbers.length; i++)
        jo+=numbers[i];
    jo=jo/numbers.length;
    double[] joArray = new double[numbers.length];
    for(int i=0; i<numbers.length; i++)
    {
        joArray[i]=Math.pow(numbers[i]-jo,2.0);
    }
    double jo2=0.0;
    for(int i=0; i<joArray.length; i++)
        jo2+=joArray[i];
    jo2=Math.sqrt(jo2/joArray.length);
    return jo2;
}


public  static  double average(int[] numbers) {
    double jo = 0.0;
    for(int i=0; i<numbers.length; i++)
        jo+=numbers[i];
    return jo/numbers.length;
}