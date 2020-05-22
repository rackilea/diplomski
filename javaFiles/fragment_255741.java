for (int i = 0; i < n; ++i) {
  CalcTask task = new CalcTask(i);
  new Thread(task).start();
}

public class CalcTask extends Task<Integer> {
    protected int id;

    public CalcTask (int id) {
        this.id = id;
    }

    public void succeeded() {
       process(this.getValue());
    }

    @Override
    public Integer call() {
        return CALCULATION_RESULT;
    }
}