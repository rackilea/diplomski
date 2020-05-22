class Main{
    public static void main(String args[]) {
        long factorial = Long.parseLong(args[0]);
        long modulo = Long.parseLong(args[1]);
        long startTime = System.nanoTime();

        long res = 1;
        for(long i = 1; i <= factorial; i++) {
            res *= i;
            res %= modulo;
        }
        System.out.println(res);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println((double)totalTime/1000000000L);
    }

}