public abstract class DataProcessor<T> {

    protected interface CallBack<T> {
        List<T> parse(String response) throws ServerException, JSONException;
    }
}