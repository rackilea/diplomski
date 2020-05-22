public class CalcTask implements Runnable {
    protected int id;

    public CalcTask (int id) {
        this.id = id;
    }

    @Override
    public void run() {
       CALCULATION_RESULT = calculate();
       process(CALCULATION_RESULT);
    }
}