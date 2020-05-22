public class Calthread implements Callable<Integer> {

    private int num = 1;

    public Calthread(int num) {
        this.num = num;
    }

    @Override
    public Integer call() {
        int dft = 1;
        for (int i = 1; i <= num; i++) {
            dft = dft * i;
        }
        return dft;
    }
}