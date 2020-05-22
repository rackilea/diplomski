public class Data {
    private static ThreadLocal<Data> datas = new ThreadLocal<Data>() {
        @Override
        protected Data initialValue() { return new Data(); }
    };

    public static Data getInstance() {
        return datas.get();
    }

    public static void removeOldDataForThisThread() { datas.remove(); }

    private Data() {
    }
}