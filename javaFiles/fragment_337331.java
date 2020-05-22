public class History extends Activity {
    public Integer Type;

    private static class HistoryAdapter extends BaseAdapter {

        Integer num;

        HistoryAdapter(Integer num) {
            this.num = num;
       }
    }

    void foo() {
        HistoryAdapter = new HistoryAdapter(Type);
    }
}