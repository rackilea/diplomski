public class Fib {
    private static int UPPER_BOUND = 4000000;
    private static int ITERS = 100;
    public static void main(String[] args) {
        long time1, time2;
        int sum1 = 0, sum2 = 0;
        long startTime = System.nanoTime();
        for (int iter = 0; iter < ITERS; ++iter) {
            sum1 = sol1();
        }
        time1 = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int iter = 0; iter < ITERS; ++iter) {
            sum2 = sol2();
        }
        time2 = System.nanoTime() - startTime;
        System.out.println("Time1 = " + time1 + "; sum1 = " + sum1);
        System.out.println("Time2 = " + time2 + "; sum2 = " + sum2);
    }

    private static int sol1() {
        int sum = 2;
        int i = 2;
        int prevNum = 1;
        while(i <= UPPER_BOUND) {
            int fibNum = generateFibNumber(prevNum,i);
            prevNum = i;
            i = fibNum;
            if (fibNum%2 == 0){
                sum += fibNum;
            }
        }
        return sum;
    }

    private static int sol2() {
        int penultimateTerm = 2;
        int prevTerm = 8;
        int currentTerm = 34;
        int sum = penultimateTerm + prevTerm;
        while (currentTerm <= UPPER_BOUND) {
            sum += currentTerm;
            penultimateTerm = prevTerm;
            prevTerm = currentTerm;
            currentTerm = (prevTerm << 2) + penultimateTerm;
        }
        return sum;
    }

    private static int generateFibNumber(int number1, int number2) {
        return number1+ number2;
    }
}