public class ConcurrentCode {

    private int countA = 0;
    private int countB = 0;

    int countA(){
        for (int i = 0; i < 1000; i++) {
            countA++;
        }
        System.out.println(countA);
        return countA;
    }

    int countB(){
        for (int i = 0; i < 1000; i++) {
            countB++;
        }
        System.out.println(countB);
        return countB;
    }

    public void execute(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // method reference introduced in Java 8
        executorService.submit(this::countA);
        executorService.submit(this::countB);

        // close executorService
        executorService.shutdown();
    }


    public static void main(String[] args){
        new ConcurrentCode().execute();
    }

}