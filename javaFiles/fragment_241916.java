private static int fibonacciRec_internal(int fibNumb_cur, Counter fibNumb_max) {
    int answer = (fibNumb_cur <= 1) ? fibNumb_cur :
                 fibonacciRec_internal(fibNumb_cur - 1, fibNumb_max) +
                 fibonacciRec_internal(fibNumb_cur - 2, fibNumb_max);
    if (fibNumb_max.getValue() < fibNumb_cur) {
        fibNumb_max.increment();
        System.out.println(answer);
    }
    return answer;
}