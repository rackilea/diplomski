public class Example<T> {

    private T data;

    static <T> Example<T> newTypedExample(Class<T> type) {
        return new Example<T>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}