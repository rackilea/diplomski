public class APSum {

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            test();
        }
    }

    private static void test() {
        long then = System.currentTimeMillis();
        sum(5000000);
        long now = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (now - then));
    }

    public static double sum(int i){
        double sum=0;
        for(int index=0; index<=i; index++){
            sum = sum + (double)index;
        }
        return sum;
    }
    }