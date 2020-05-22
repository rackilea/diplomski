public class ParallelCollatz implements Callable<Long> {

    private final long inputNumInit;

    public ParallelCollatz(long inputNumInit) {
        this.inputNumInit = inputNumInit;
    }


    @Override
    public Long call() {
        long result = 1;
        long inputNum = inputNumInit;
        //main recursive computation
        while (inputNum > 1) {

            if (inputNum % 2 == 0) {
                inputNum = inputNum / 2;
            } else {
                inputNum = inputNum * 3 + 1;
            }
            ++result;
        }
        return result;
    }

}